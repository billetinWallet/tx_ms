package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.RechargeRecordDto;
import com.wallet.tx_ms.models.RechargeModel;
import com.wallet.tx_ms.repositories.RechargeRepository;
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
    public ResponseEntity<RechargeModel> createRecharge(@RequestBody RechargeRecordDto rechargeRecordDto){
        var rechargeModel = new RechargeModel();
        BeanUtils.copyProperties(rechargeRecordDto, rechargeModel);
        rechargeModel.setState('P');
        return ResponseEntity.status(HttpStatus.CREATED).body(rechargeRepository.save(rechargeModel));
    }

    @GetMapping("/recharges")
    public ResponseEntity<List<RechargeModel>> getRecharges(){
        return ResponseEntity.status(HttpStatus.OK).body(rechargeRepository.findAll());
    }

    @PatchMapping("/recharges/{id_recharge}/{state}")
    public ResponseEntity<RechargeModel> updateRecharge(@PathVariable(value="id_recharge") UUID id_recharge, @PathVariable(value="state") char state){
        try{
            RechargeModel recharge = rechargeRepository.findById(id_recharge).get();
            if (recharge.getState()!='P')
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            recharge.setState(state);
            return new ResponseEntity<RechargeModel>(rechargeRepository.save(recharge), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
