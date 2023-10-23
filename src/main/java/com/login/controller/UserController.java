package com.login.controller;

import com.login.entity.UserEntity;
import com.login.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @PostMapping
  public UserEntity cadastrar(@RequestBody @Valid UserEntity user){
    return userRepository.save(user);
  }

  @GetMapping
  public List<UserEntity> usuarios(){
    return userRepository.findAll();
  }
}
