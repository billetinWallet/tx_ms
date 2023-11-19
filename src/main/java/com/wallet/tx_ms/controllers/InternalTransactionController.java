package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.InternalTransactionRecordDto;
import com.wallet.tx_ms.models.InternalTransactionModel;
import com.wallet.tx_ms.repositories.InternalTransactionRepository;
import com.wallet.tx_ms.security.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InternalTransactionController {

    @Autowired
    InternalTransactionRepository internalTransactionRepository;

    @PostMapping("/internal_transactions")
    public ResponseEntity<Object> createInternalTransaction(@RequestHeader("Authorization") String bearer, @RequestBody InternalTransactionRecordDto internalTransactionRecordDto){
        if(Validator.validateUser(bearer, Integer.toString(internalTransactionRecordDto.source_account().getId_user())) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        var internalTransactionModel = new InternalTransactionModel();
        BeanUtils.copyProperties(internalTransactionRecordDto, internalTransactionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(internalTransactionRepository.save(internalTransactionModel));
    }

    @GetMapping("/internal_transactions")
    public ResponseEntity<Object> getInternalTransactions(@RequestHeader("Authorization") String bearer){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        return ResponseEntity.status(HttpStatus.OK).body(internalTransactionRepository.findAll());
    }
}
