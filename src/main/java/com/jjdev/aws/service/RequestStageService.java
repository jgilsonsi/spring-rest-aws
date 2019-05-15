package com.jjdev.aws.service;

import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.domain.enums.RequestState;
import com.jjdev.aws.repository.RequestRepository;
import com.jjdev.aws.repository.RequestStageRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestStageService {

    @Autowired
    private RequestStageRepository requestStageRepository;

    @Autowired
    private RequestRepository requestRepository;

    public RequestStage save(RequestStage stage) {
        stage.setRealizationDate(new Date());
        RequestStage createdStage = requestStageRepository.save(stage);

        Long requestid = stage.getRequest().getId();
        RequestState state = stage.getState();

        requestRepository.updateStatus(requestid, state);

        return createdStage;
    }

    public RequestStage getById(Long id) {
        Optional<RequestStage> result = requestStageRepository.findById(id);
        return result.get();
    }

    public List<RequestStage> listAllByrequestId(Long requestId) {
        List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
        return stages;
    }

}
