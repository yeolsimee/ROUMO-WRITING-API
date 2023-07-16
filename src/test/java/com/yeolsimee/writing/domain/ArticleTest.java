package com.yeolsimee.writing.domain;

import com.yeolsimee.writing.domain.article.entity.Article;
import com.yeolsimee.writing.domain.article.entity.ArticleImage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleTest {

	@Test
	void createRecommendRoutine() {
		ArticleImage articleImage = new ArticleImage("imageName", "imageUrl", "originalIamgeName");
		Article article = new Article("http://test.com", articleImage);

		Assertions.assertThat(article.getSiteUrl()).isEqualTo("http://test.com");
	}
}