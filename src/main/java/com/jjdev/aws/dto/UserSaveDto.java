package com.jjdev.aws.dto;

import com.jjdev.aws.domain.Request;
import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.domain.User;
import com.jjdev.aws.domain.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSaveDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(min = 7, max = 99, message = "Password must bu between {min} and {max}")
    private String password;

    @NotNull
    private Role role;

    private List<Request> requests = new ArrayList<>();
    private List<RequestStage> stages = new ArrayList<>();

    public User transformToUser() {
        return new User(null, this.name, this.email, this.password, this.role, this.requests, this.stages);
    }

}
