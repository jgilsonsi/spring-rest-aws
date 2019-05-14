package com.jjdev.aws.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jjdev.aws.domain.Request;
import com.jjdev.aws.domain.User;
import com.jjdev.aws.domain.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTests {

    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void AsaveTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request(null, "New Laptop HP", "I'd like to buy a laptop", new Date(), RequestState.OPEN,
                owner, null);
        Request createdRequest = requestRepository.save(request);

        assertThat(createdRequest.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest() {
        User owner = new User();
        owner.setId(1L);

        Request request = new Request(1L, "New Laptop HP", "I'd like to buy a laptop with 16Gb RAM", null,
                RequestState.OPEN, owner, null);
        Request updatedRequest = requestRepository.save(request);

        assertThat(updatedRequest.getDescription()).isEqualTo("I'd like to buy a laptop with 16Gb RAM");
    }

    @Test
    public void getByIdTest() {
        Optional<Request> result = requestRepository.findById(1L);
        Request request = result.get();

        assertThat(request.getSubject()).isEqualTo("New Laptop HP");
    }

    @Test
    public void listTest() {
        List<Request> requests = requestRepository.findAll();

        assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    public void listByOwnerIdTest() {
        List<Request> requests = requestRepository.findAllByOwnerId(1L);

        assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    public void updateStatusTest() {
        int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);
        assertThat(affectedRows).isEqualTo(1);
    }

}
