package com.yeolsimee.writing.web.article.dto;

import com.yeolsimee.writing.domain.article.entity.Article;
import com.yeolsimee.writing.domain.article.entity.ArticleImage;
import com.yeolsimee.writing.domain.article.entity.ArticleType;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InsertExternalArticleDto {
	private String articleType;
	@NotBlank(message = "사이트 URL은 필수 입력 값입니다.")
	private String siteUrl;
	@NotBlank(message = "썸네일 이미지는 필수 입력 값입니다.")
	private MultipartFile thumbnailFile;

	public InsertExternalArticleDto() {
	}

	@Builder
	public InsertExternalArticleDto(String articleType, String siteUrl, MultipartFile thumbnailFile) {
		this.articleType = articleType;
		this.siteUrl = siteUrl;
		this.thumbnailFile = thumbnailFile;
	}

	public static Article toEntity(InsertExternalArticleDto insertExternalArticleDto, ArticleImage articleImage) {
		return Article.builder()
				.articleType(ArticleType.valueOf(insertExternalArticleDto.getArticleType()))
				.siteUrl(insertExternalArticleDto.getSiteUrl())
				.articleImage(articleImage)
				.build();
	}
}
