package com.login.services;

import com.login.dtos.UserDto;
import com.login.entity.UserEntity;
import com.login.entity.UserRolesEntity;
import com.login.repository.RoleRepository;
import com.login.repository.UserRepository;
import com.login.repository.UserRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.login.entity.RoleEntity;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRolesRepository userRolesRepository;

    @PostMapping
    public UserEntity cadastrar(UserDto user){
        RoleEntity role = roleRepository.findByRoleName(user.getRole());
        UserEntity userSave = userRepository.save(UserEntity.builder()
                    .userName(user.getUserName())
                    .password(user.getPassword())
                    .build());

        userRolesRepository.save(
            UserRolesEntity.builder()
            .user(userSave)
            .role(role)
            .build());
        return userSave;
    }
}
