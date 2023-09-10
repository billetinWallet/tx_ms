package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.TransactionTypeRecordDto;
import com.wallet.tx_ms.models.TransactionTypeModel;
import com.wallet.tx_ms.repositories.TransactionTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionTypeController {

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @PostMapping("/transaction_types")
    public ResponseEntity<TransactionTypeModel> createTransactionType(@RequestBody TransactionTypeRecordDto transactionTypeRecordDto){
        var transactionTypeModel = new TransactionTypeModel();
        BeanUtils.copyProperties(transactionTypeRecordDto, transactionTypeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionTypeRepository.save(transactionTypeModel));
    }

    @GetMapping("/transaction_types")
    public ResponseEntity<List<TransactionTypeModel>> getTransactionTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionTypeRepository.findAll());
    }

    @GetMapping("transaction_types/{id}")
    public ResponseEntity<Object> getTransaction(@PathVariable(value="id") int id){
        Optional<TransactionTypeModel> transactionType = transactionTypeRepository.findById(id);
        return transactionType.<ResponseEntity<Object>>map(transactionTypeModel -> ResponseEntity.status(HttpStatus.OK).body(transactionTypeModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaction type does not exist"));
    }
}
