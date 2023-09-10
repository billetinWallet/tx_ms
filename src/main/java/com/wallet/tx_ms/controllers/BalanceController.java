package com.wallet.tx_ms.controllers;

import com.wallet.tx_ms.dtos.BalanceRecordDto;
import com.wallet.tx_ms.models.BalanceModel;
import com.wallet.tx_ms.models.UserModel;
import com.wallet.tx_ms.repositories.BalanceRepository;
import org.apache.coyote.Response;
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
public class BalanceController {

    @Autowired
    BalanceRepository balanceRepository;

    @PostMapping("/balance")
    public ResponseEntity<BalanceModel> createBalance(@RequestBody BalanceRecordDto balanceRecordDto){
        var balanceModel = new BalanceModel();
        BeanUtils.copyProperties(balanceRecordDto, balanceModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(balanceRepository.save(balanceModel));
    }

    @GetMapping("/balance")
    public ResponseEntity<List<BalanceModel>> getBalances(){
        return ResponseEntity.status(HttpStatus.OK).body(balanceRepository.findAll());
    }
}
