package com.login.repository;

import com.login.entity.RoleEntity;
import com.login.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
  RoleEntity findByRoleName(RoleName name);
}
