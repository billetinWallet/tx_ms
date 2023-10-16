package com.wallet.tx_ms.controllers;


import com.wallet.tx_ms.dtos.MovementRecordDto;
import com.wallet.tx_ms.models.MovementModel;
import com.wallet.tx_ms.models.UserModel;
import com.wallet.tx_ms.repositories.MovementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/movements/{id_user}")
    public ResponseEntity<Object> getUser(@PathVariable(value="id_user") int id_user){
        Optional<List<MovementModel>> movements = movementRepository.findByUserId(id_user);
        return movements.<ResponseEntity<Object>>map(movementModel -> ResponseEntity.status(HttpStatus.OK).body(movementModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist or does not have any movement yet."));
    }
}
