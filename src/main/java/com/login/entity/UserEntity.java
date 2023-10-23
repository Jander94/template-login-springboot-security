package com.login.entity;

import com.login.enums.RoleName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;

  @Column(nullable = false)
  @NotEmpty(message = "UserName é obrigatório.")
  private String userName;

  @Column(nullable = false)
  @NotEmpty(message = "Password é obrigatório.")
  private String password;

  @ManyToMany
  @JoinTable(name = "TB_USER_ROLES",
      joinColumns = @JoinColumn(name = "userId"),
      inverseJoinColumns = @JoinColumn(name = "roleId")
  )
  private List<RoleEntity> roles;

}
