package com.porpapps.wealthwatchapi.controller;

import com.porpapps.wealthwatchapi.model.User;
import com.porpapps.wealthwatchapi.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository; //ponto de injeção: acessar Jpa

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        final User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Integer id) {
        final Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        var user = userOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        userRepository.delete(userOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
