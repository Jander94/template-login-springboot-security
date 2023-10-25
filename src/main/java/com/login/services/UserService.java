package com.login.services;

import com.login.dtos.UserDto;
import com.login.entity.RoleEntity;
import com.login.entity.UserEntity;
import com.login.entity.UserRolesEntity;
import com.login.repository.RoleRepository;
import com.login.repository.UserRepository;
import com.login.repository.UserRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRolesRepository userRolesRepository;

    @PostMapping
    public ResponseEntity cadastrar(UserDto user){
        RoleEntity role = roleRepository.findByRoleName(user.getRole());
        UserEntity userSave = new UserEntity();
        userSave.setUserName(user.getUserName());
        userSave.setPassword(user.getPassword());

        if(role == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A role informada não existe");
        }
        userRepository.save(userSave);
        userRolesRepository.save(
                UserRolesEntity.builder()
                        .user(userSave)
                        .role(role)
                        .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }
}
