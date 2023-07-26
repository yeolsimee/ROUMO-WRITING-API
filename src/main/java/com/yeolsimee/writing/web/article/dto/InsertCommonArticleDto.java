package com.yeolsimee.writing.web.article.dto;

import com.yeolsimee.writing.domain.article.entity.Article;
import com.yeolsimee.writing.domain.article.entity.ArticleContent;
import com.yeolsimee.writing.domain.article.entity.ArticleImage;
import com.yeolsimee.writing.domain.article.entity.ArticleType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class InsertCommonArticleDto {
	private String articleType;
	@NotBlank(message = "화면타이틀은 필수 입력 값입니다.")
	private String articleTitle;
	@NotBlank(message = "제목은 필수 입력 값입니다.")
	private String articleSubject;
	@NotBlank(message = "부제목은 필수 입력 값입니다.")
	private String articleSubSubject;
	@NotBlank(message = "인터뷰서론은 필수 입력 값입니다.")
	private String articleIntroduction;
	private List<ArticleContent> articleContents = new ArrayList<>();
	private List<String> articleRecommendRoutines = new ArrayList<>();
	private MultipartFile thumbnailFile;

	public InsertCommonArticleDto() {
	}

	public static Article toEntity(InsertCommonArticleDto insertCommonArticleDto, ArticleImage articleImage) {
		return Article.builder()
				.articleType(ArticleType.valueOf(insertCommonArticleDto.getArticleType()))
				.articleTitle(insertCommonArticleDto.getArticleTitle())
				.articleSubject(insertCommonArticleDto.getArticleSubject())
				.articleSubSubject(insertCommonArticleDto.getArticleSubSubject())
				.articleIntroduction(insertCommonArticleDto.getArticleIntroduction())
				.articleContents(insertCommonArticleDto.getArticleContents())
				.articleRecommendRoutines(insertCommonArticleDto.getArticleRecommendRoutines())
				.articleImage(articleImage)
				.build();
	}
}
