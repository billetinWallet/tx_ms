package com.wallet.tx_ms.controllers;

import com.wallet.tx_ms.dtos.BalanceRecordDto;
import com.wallet.tx_ms.models.BalanceModel;
import com.wallet.tx_ms.models.UserModel;
import com.wallet.tx_ms.repositories.BalanceRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/balance/{id_user}")
    public ResponseEntity<Object> getBalanceByUserId(@PathVariable(value="id_user") int id_user){
        Optional<BalanceModel> balance = balanceRepository.findLastByUserId(id_user);
        return balance.<ResponseEntity<Object>>map(balanceModel -> ResponseEntity.status(HttpStatus.OK).body(balanceModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist"));
    }
}
