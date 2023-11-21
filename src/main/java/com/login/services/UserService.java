package com.login.services;

import com.login.dtos.UserDto;
import com.login.dtos.UsersDTO;
import com.login.entity.RolesEntity;
import com.login.entity.UserEntity;
import com.login.repository.RoleRepository;
import com.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public ResponseEntity<String> cadastrar(UserDto user) {
    if (user == null || user.getRole() == null) {
      return ResponseEntity.badRequest().build();
    }
    RolesEntity role = roleRepository.findByRoleName(user.getRole());
    if(role == null){
      return ResponseEntity.badRequest().build();
    }
    UserEntity userSave = new UserEntity();
    userSave.setUserName(user.getUserName());
    userSave.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    userSave.setRoles(List.of(role));
    if (userSave != null) {
      userRepository.save(userSave);
      return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  public List<UsersDTO> buscarUsuarios(){
    List<UserEntity> userData = userRepository.findAll();
    if(userData.isEmpty()){
      return new ArrayList<>();
    }
    List<UsersDTO> usersReturn = new ArrayList<>();
    userData.forEach((user) -> {
      usersReturn.add(UsersDTO
          .builder()
          .userName(user.getUsername())
          .role(user.getRoles().get(0).getRoleName())
          .build()
      );
    });
    return usersReturn;
  }
}
