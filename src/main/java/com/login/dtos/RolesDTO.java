package com.login.dtos;

import com.login.enums.RoleName;
import lombok.*;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {
  private UUID id;
  private RoleName roleName;

}
