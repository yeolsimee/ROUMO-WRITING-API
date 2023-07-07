package com.yeolsimee.writing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecommendRoutineTest {

	@Test
	void createRecommendRoutine() {
		RecommendRoutine recommendRoutine = new RecommendRoutine("http://test.com", "http://testImage.com");

		Assertions.assertThat(recommendRoutine.getSiteUrl()).isEqualTo("http://test.com");
	}
}