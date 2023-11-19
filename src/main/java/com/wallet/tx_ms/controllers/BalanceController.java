package com.wallet.tx_ms.controllers;

import com.wallet.tx_ms.dtos.BalanceRecordDto;
import com.wallet.tx_ms.models.BalanceModel;
import com.wallet.tx_ms.repositories.BalanceRepository;
import com.wallet.tx_ms.security.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class BalanceController{

    @Autowired
    BalanceRepository balanceRepository;

    @Autowired
    Validator validator;

    @PostMapping("/balance")
    public ResponseEntity<Object> createBalance(@RequestHeader("Authorization") String bearer, @RequestBody BalanceRecordDto balanceRecordDto){
        if(validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        var balanceModel = new BalanceModel();
        BeanUtils.copyProperties(balanceRecordDto, balanceModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(balanceRepository.save(balanceModel));
    }

    @GetMapping("/balance")
    public ResponseEntity<Object> getBalances(@RequestHeader("Authorization") String bearer){
        if(validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        return ResponseEntity.status(HttpStatus.OK).body(balanceRepository.findAll());
    }

    @GetMapping("/balance/{id_user}")
    public ResponseEntity<Object> getBalanceByUserId(@RequestHeader("Authorization") String bearer, @PathVariable(value="id_user") int id_user){
        if(validator.validateUser(bearer, Integer.toString(id_user)) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        Optional<BalanceModel> balance = balanceRepository.findLastByUserId(id_user);
        return balance.<ResponseEntity<Object>>map(balanceModel -> ResponseEntity.status(HttpStatus.OK).body(balanceModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist"));
    }
}
