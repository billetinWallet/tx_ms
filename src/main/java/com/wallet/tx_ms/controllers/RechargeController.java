package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.PaymentRecordDto;
import com.wallet.tx_ms.dtos.RechargeRecordDto;
import com.wallet.tx_ms.models.PaymentModel;
import com.wallet.tx_ms.models.RechargeModel;
import com.wallet.tx_ms.repositories.RechargeRepository;
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
public class RechargeController {

    @Autowired
    RechargeRepository rechargeRepository;

    @PostMapping("/recharges")
    public ResponseEntity<RechargeModel> createRecharge(@RequestBody RechargeRecordDto rechargeRecordDto){
        var rechargeModel = new RechargeModel();
        BeanUtils.copyProperties(rechargeRecordDto, rechargeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(rechargeRepository.save(rechargeModel));
    }

    @GetMapping("/recharges")
    public ResponseEntity<List<RechargeModel>> getRecharges(){
        return ResponseEntity.status(HttpStatus.OK).body(rechargeRepository.findAll());
    }
}
