package com.jjdev.aws.dto;

import com.jjdev.aws.domain.Request;
import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(min = 7, max = 99, message = "Password must bu between {min} and {max}")
    private String password;

    private List<Request> requests = new ArrayList<>();
    private List<RequestStage> stages = new ArrayList<>();

    public User transformToUser() {
        return new User(this.id, this.name, this.email, this.password, null, this.requests, this.stages);
    }

}
