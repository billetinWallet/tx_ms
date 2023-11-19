package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.PaymentRecordDto;
import com.wallet.tx_ms.models.PaymentModel;
import com.wallet.tx_ms.repositories.PaymentRepository;
import com.wallet.tx_ms.security.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/payments")
    public ResponseEntity<Object> createPayment(@RequestHeader("Authorization") String bearer, @RequestBody PaymentRecordDto paymentRecordDto){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        var paymentModel = new PaymentModel();
        BeanUtils.copyProperties(paymentRecordDto, paymentModel);
        paymentModel.setState('P');
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentRepository.save(paymentModel));
    }

    @GetMapping("/payments")
    public ResponseEntity<Object> getPayments(@RequestHeader("Authorization") String bearer){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findAll());
    }

    @PatchMapping("/payments/{id_payment}/{state}")
    public ResponseEntity<Object> updatePayment(@RequestHeader("Authorization") String bearer, @PathVariable(value="id_payment") UUID id_payment, @PathVariable(value="state") char state){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        try{
            PaymentModel payment = paymentRepository.findById(id_payment).get();
            if (payment.getState()!='P')
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            payment.setState(state);
            return new ResponseEntity<Object>(paymentRepository.save(payment), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
