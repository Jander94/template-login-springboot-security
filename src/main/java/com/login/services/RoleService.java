package com.login.services;

import com.login.dtos.RolesDTO;
import com.login.entity.RolesEntity;
import com.login.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

  private final RoleRepository roleRepository;

  public List<RolesDTO> buscarRoles() {
    List<RolesEntity> rolesData = roleRepository.findAll();
    if(rolesData.isEmpty()){
      return new ArrayList<>();
    }
    List<RolesDTO> rolesReturn = new ArrayList<>();
    rolesData.forEach((role) -> {
      rolesReturn.add(RolesDTO
          .builder()
          .id(role.getId())
          .roleName(role.getRoleName())
          .build()
      );
    });
    return rolesReturn;
  }
}
