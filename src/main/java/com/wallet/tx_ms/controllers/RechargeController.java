package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.RechargeRecordDto;
import com.wallet.tx_ms.models.RechargeModel;
import com.wallet.tx_ms.repositories.RechargeRepository;
import com.wallet.tx_ms.security.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RechargeController {

    @Autowired
    RechargeRepository rechargeRepository;

    @PostMapping("/recharges")
    public ResponseEntity<Object> createRecharge(@RequestHeader("Authorization") String bearer, @RequestBody RechargeRecordDto rechargeRecordDto){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        var rechargeModel = new RechargeModel();
        BeanUtils.copyProperties(rechargeRecordDto, rechargeModel);
        rechargeModel.setState('P');
        return ResponseEntity.status(HttpStatus.CREATED).body(rechargeRepository.save(rechargeModel));
    }

    @GetMapping("/recharges")
    public ResponseEntity<Object> getRecharges(@RequestHeader("Authorization") String bearer){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        return ResponseEntity.status(HttpStatus.OK).body(rechargeRepository.findAll());
    }

    @PatchMapping("/recharges/{id_recharge}/{state}")
    public ResponseEntity<Object> updateRecharge(@RequestHeader("Authorization") String bearer, @PathVariable(value="id_recharge") UUID id_recharge, @PathVariable(value="state") char state){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        try{
            RechargeModel recharge = rechargeRepository.findById(id_recharge).get();
            if (recharge.getState()!='P')
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            recharge.setState(state);
            return new ResponseEntity<Object>(rechargeRepository.save(recharge), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
