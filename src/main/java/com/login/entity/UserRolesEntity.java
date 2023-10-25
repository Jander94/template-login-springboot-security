package com.login.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.util.UUID;

@Entity
@Table(name = "TB_USER_ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRolesEntity {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "userId")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "roleId")
  private RoleEntity role;

}
