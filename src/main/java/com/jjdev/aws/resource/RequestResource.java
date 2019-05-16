package com.jjdev.aws.resource;

import com.jjdev.aws.domain.Request;
import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.dto.RequestSaveDto;
import com.jjdev.aws.dto.RequestUpdateDto;
import com.jjdev.aws.model.PageModel;
import com.jjdev.aws.model.PageRequestModel;
import com.jjdev.aws.service.RequestService;
import com.jjdev.aws.service.RequestStageService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestStageService requestStageService;

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody @Valid RequestSaveDto requestSaveDto) {
        Request createdRequest = requestService.save(requestSaveDto.transformRequest());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable(name = "id") Long id, @RequestBody @Valid RequestUpdateDto requestUpdateDto) {
        requestUpdateDto.setId(id);
        Request updatedRequest = requestService.save(requestUpdateDto.transformRequest());
        return ResponseEntity.ok(updatedRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id) {
        Request request = requestService.getById(id);
        return ResponseEntity.ok(request);
    }

    @GetMapping
    public ResponseEntity<PageModel<Request>> listAll(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        PageRequestModel pr = new PageRequestModel(page, size);

        PageModel<Request> pm = requestService.listAllByLazyMode(pr);
        return ResponseEntity.ok(pm);
    }

    @GetMapping("/{id}/request-stages")
    public ResponseEntity<PageModel<RequestStage>> listAllRequestStagesById(@PathVariable(name = "id") Long id,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        PageRequestModel pr = new PageRequestModel(page, size);

        PageModel<RequestStage> pm = requestStageService.listAllByRequestIdByLazyMode(id, pr);
        return ResponseEntity.ok(pm);
    }

}
