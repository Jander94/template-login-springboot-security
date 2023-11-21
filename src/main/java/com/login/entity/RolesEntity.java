package com.login.entity;

import com.login.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ROLES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolesEntity implements GrantedAuthority, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RoleName roleName;

  @Override
  public String getAuthority() {
    return this.roleName.toString();
  }
}
