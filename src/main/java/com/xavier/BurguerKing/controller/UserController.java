package com.xavier.BurguerKing.controller;


import com.xavier.BurguerKing.Service.UserService;
import com.xavier.BurguerKing.dto.UserDto;
import com.xavier.BurguerKing.model.UserModel;
import com.xavier.BurguerKing.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserDto>> listar(){
        List<UserDto> user = userService.listAll();
        if (user.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("USUARIO CRIADO COM SUCESSO: " + userDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto,@PathVariable Long id){
        UserDto user = userService.updateUser(id,userDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> findId(@PathVariable Long id){
        UserDto user = userService.findbyId(id);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id: " + id + " not found");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Optional<UserDto>> deleteUser(@PathVariable Long id){
         Optional<UserDto> user = userService.deletar(id);
         if (user.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body(user);
         }else{
             return ResponseEntity.ok(user);
         }
    }
}
