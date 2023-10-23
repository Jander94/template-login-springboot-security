package com.login.controller;

import com.login.entity.RoleEntity;
import com.login.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RoleRepository roleRepository;

    @PostMapping
    public RoleEntity cadastrar(@RequestBody RoleEntity role){
        return roleRepository.save(role);
    }
}
