package com.wallet.tx_ms.controllers;

import com.wallet.tx_ms.dtos.UserRecordDto;
import com.wallet.tx_ms.models.UserModel;
import com.wallet.tx_ms.repositories.UserRepository;
import com.wallet.tx_ms.security.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestHeader("Authorization") String bearer, @RequestBody UserRecordDto userRecordDto){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(@RequestHeader("Authorization") String bearer){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUser(@RequestHeader("Authorization") String bearer, @PathVariable(value="id") int id){
        if(Validator.validateUser(bearer, Integer.toString(id)) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        Optional<UserModel> user = userRepository.findById(id);
        return user.<ResponseEntity<Object>>map(userModel -> ResponseEntity.status(HttpStatus.OK).body(userModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist"));
    }

    @GetMapping("/users/getId/{document}")
    public ResponseEntity<Object> getUserId(@RequestHeader("Authorization") String bearer, @PathVariable(value="document") int document){
        if(Validator.validateToken(bearer) == false){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
        }
        Optional<UserModel> user = userRepository.getUserId(document);
        return user.<ResponseEntity<Object>>map(userModel -> ResponseEntity.status(HttpStatus.OK).body(userModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist"));
    }
}
