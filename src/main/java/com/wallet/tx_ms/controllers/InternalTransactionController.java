package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.InternalTransactionRecordDto;
import com.wallet.tx_ms.models.InternalTransactionModel;
import com.wallet.tx_ms.repositories.InternalTransactionRepository;
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
public class InternalTransactionController {

    @Autowired
    InternalTransactionRepository internalTransactionRepository;

    @PostMapping("/internal_transactions")
    public ResponseEntity<InternalTransactionModel> createInternalTransaction(@RequestBody InternalTransactionRecordDto internalTransactionRecordDto){
        var internalTransactionModel = new InternalTransactionModel();
        BeanUtils.copyProperties(internalTransactionRecordDto, internalTransactionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(internalTransactionRepository.save(internalTransactionModel));
    }

    @GetMapping("/internal_transactions")
    public ResponseEntity<List<InternalTransactionModel>> getInternalTransactions(){
        return ResponseEntity.status(HttpStatus.OK).body(internalTransactionRepository.findAll());
    }
}
