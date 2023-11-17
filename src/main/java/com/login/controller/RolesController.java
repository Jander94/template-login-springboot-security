package com.login.controller;

import com.login.entity.RolesEntity;
import com.login.entity.UserEntity;
import com.login.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RoleRepository roleRepository;

    @PostMapping
    public RolesEntity cadastrar(@RequestBody RolesEntity role){
        return roleRepository.save(role);
    }

    @GetMapping
    public List<RolesEntity> roles(){
        return roleRepository.findAll();
    }
}
