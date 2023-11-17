package com.login.services;

import com.login.dtos.UserDto;
import com.login.entity.RolesEntity;
import com.login.entity.UserEntity;
import com.login.repository.RoleRepository;
import com.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public ResponseEntity<UserEntity> cadastrar(UserDto user) {
    if (user == null || user.getRole() == null) {
      return ResponseEntity.badRequest().build();
    }
    RolesEntity role = roleRepository.findByRoleName(user.getRole());
    UserEntity userSave = new UserEntity();
    userSave.setUserName(user.getUserName());
    userSave.setPassword(user.getPassword());
    userSave.setRoles(List.of(role));
    if (userSave != null) {
      return ResponseEntity.ok(userRepository.save(userSave));
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
