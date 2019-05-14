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
import com.jjdev.aws.domain.RequestStage;
import com.jjdev.aws.domain.User;
import com.jjdev.aws.domain.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestStageRepositoryTests {

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);

		Request request = new Request();
		request.setId(1L);

		RequestStage stage = new RequestStage(null, "A new labptop was bought", new Date(), RequestState.CLOSED,
				request, owner);
		RequestStage createdRequestStage = requestStageRepository.save(stage);

		assertThat(createdRequestStage.getId()).isEqualTo(1L);
	}

	@Test
	public void getByIdTest() {
		Optional<RequestStage> result = requestStageRepository.findById(1L);
		RequestStage stage = result.get();

		assertThat(stage.getDescription()).isEqualTo("A new labptop was bought");
	}

	@Test
	public void listByRequestIdTest() {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(1L);

		assertThat(stages.size()).isEqualTo(1);
	}

}
