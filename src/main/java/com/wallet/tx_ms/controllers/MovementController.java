package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.MovementRecordDto;
import com.wallet.tx_ms.models.MovementModel;
import com.wallet.tx_ms.repositories.MovementRepository;
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
public class MovementController {

    @Autowired
    MovementRepository movementRepository;

    @PostMapping("/movements")
    public ResponseEntity<MovementModel> createMovement(@RequestBody MovementRecordDto movementRecordDto){
        var movementModel = new MovementModel();
        BeanUtils.copyProperties(movementRecordDto, movementModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(movementRepository.save(movementModel));
    }

    @GetMapping("/movements")
    public ResponseEntity<List<MovementModel>> getMovements(){
        return ResponseEntity.status(HttpStatus.OK).body(movementRepository.findAll());
    }
}
