package com.jjdev.aws.dto;

import com.jjdev.aws.domain.Request;
import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.domain.User;
import com.jjdev.aws.domain.enums.RequestState;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestStageSaveDto {

    private String description;

    @NotNull(message = "State is required")
    private RequestState state;

    @NotNull(message = "Request is required")
    private Request request;

    @NotNull(message = "Owner is required")
    private User owner;

    public RequestStage transformtoRequestStage() {
        return new RequestStage(null, this.description, null, this.state, this.request, this.owner);
    }

}
