package com.login.repository;

import com.login.entity.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRolesRepository extends JpaRepository<UserRolesEntity, UUID> {
}
