package com.login.dtos;

import com.login.enums.RoleName;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
  private String userName;
  private RoleName role;
}
