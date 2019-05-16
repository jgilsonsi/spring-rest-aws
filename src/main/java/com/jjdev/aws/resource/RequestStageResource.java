package com.jjdev.aws.resource;

import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.dto.RequestStageSaveDto;
import com.jjdev.aws.service.RequestStageService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResource {

    @Autowired
    private RequestStageService requestStageService;

    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody @Valid RequestStageSaveDto requestStageSaveDto) {
        RequestStage createdRequestStage = requestStageService.save(requestStageSaveDto.transformtoRequestStage());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
        RequestStage requestStage = requestStageService.getById(id);
        return ResponseEntity.ok(requestStage);
    }

}
