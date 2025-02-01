package com.spring_security.demo.controller;

import com.spring_security.demo.entities.JavaUser;
import com.spring_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<JavaUser>> getAllUser(){
        List<JavaUser> obj = userService.getAllUser();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<JavaUser> saveUser(@RequestBody JavaUser obj) {
        JavaUser save = userService.createUser(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/loginUser") // Token de confirmação do login
    public ResponseEntity<?> enterUser(@RequestBody JavaUser userCredenciais) {
        boolean obj = userService.userEnterAuth(userCredenciais);

        if (obj){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Seja bem vindo.");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Não autorizado");
    }
}
