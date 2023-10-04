package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.PaymentRecordDto;
import com.wallet.tx_ms.models.MovementModel;
import com.wallet.tx_ms.models.PaymentModel;
import com.wallet.tx_ms.repositories.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/payments")
    public ResponseEntity<PaymentModel> createPayment(@RequestBody PaymentRecordDto paymentRecordDto){
        var paymentModel = new PaymentModel();
        BeanUtils.copyProperties(paymentRecordDto, paymentModel);
        paymentModel.setState('P');
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentRepository.save(paymentModel));
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentModel>> getPayments(){
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findAll());
    }

    @PatchMapping("/payments/{id_payment}/{state}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable(value="id_payment") UUID id_payment, @PathVariable(value="state") char state){
        try{
            PaymentModel payment = paymentRepository.findById(id_payment).get();
            if (payment.getState()!='P')
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            payment.setState(state);
            return new ResponseEntity<PaymentModel>(paymentRepository.save(payment), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
