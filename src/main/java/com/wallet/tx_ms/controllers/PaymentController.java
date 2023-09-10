package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.PaymentRecordDto;
import com.wallet.tx_ms.models.MovementModel;
import com.wallet.tx_ms.models.PaymentModel;
import com.wallet.tx_ms.repositories.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/payments")
    public ResponseEntity<PaymentModel> createPayment(@RequestBody PaymentRecordDto paymentRecordDto){
        var paymentModel = new PaymentModel();
        BeanUtils.copyProperties(paymentRecordDto, paymentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentRepository.save(paymentModel));
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentModel>> getPayments(){
        return ResponseEntity.status(HttpStatus.OK).body(paymentRepository.findAll());
    }

}
