package com.login.controller;

import com.login.dtos.UserDto;
import com.login.dtos.UsersDTO;
import com.login.repository.UserRepository;
import com.login.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;
  private final UserService userService;

  @PostMapping
  public ResponseEntity<String> cadastrar(@RequestBody @Valid UserDto user){
    return userService.cadastrar(user);
  }

  @GetMapping
  public List<UsersDTO> usuarios(){
//    return userRepository.findAll();
    return userService.buscarUsuarios();
  }
}
