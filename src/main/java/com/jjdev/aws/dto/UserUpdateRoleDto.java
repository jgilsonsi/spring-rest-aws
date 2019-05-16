package com.jjdev.aws.dto;

import com.jjdev.aws.domain.enums.Role;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdateRoleDto {

    @NotNull(message = "Role is required")
    private Role role;

}
