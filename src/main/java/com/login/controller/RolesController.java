package com.login.controller;

import com.login.dtos.RolesDTO;
import com.login.entity.RolesEntity;
import com.login.repository.RoleRepository;
import com.login.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RoleRepository roleRepository;
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody RolesEntity role){
        var save = roleRepository.save(role);
        if(save != null){
            return ResponseEntity.ok("Role cadastrada com sucesso!");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public List<RolesDTO> roles(){
        return roleService.buscarRoles();
    }
}
