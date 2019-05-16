package com.jjdev.aws.dto;

import com.jjdev.aws.domain.Request;
import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestSaveDto {

    @NotBlank(message = "Subject required")
    private String subject;

    private String description;

    @NotNull(message = "Owner is required")
    private User owner;

    private List<RequestStage> stages = new ArrayList<>();

    public Request transformRequest() {
        return new Request(null, this.subject, this.description, null, null, this.owner, this.stages);
    }

}
