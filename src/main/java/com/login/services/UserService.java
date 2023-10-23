package com.login.services;

import com.login.dtos.UserDto;
import com.login.entity.UserEntity;
import com.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @PostMapping
    public UserEntity cadastrar(UserDto user){
        UserEntity userSave = userRepository.save(UserEntity.builder()
                    .userName(user.getUserName())
                    .password(user.getPassword())
                    .build());

        return null;
    }
}
