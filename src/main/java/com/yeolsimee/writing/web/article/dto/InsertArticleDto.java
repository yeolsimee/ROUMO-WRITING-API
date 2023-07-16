package com.yeolsimee.writing.web.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InsertArticleDto {
	@NotBlank(message = "사이트 URL은 필수 입력 값입니다.")
	private String siteUrl;
	private MultipartFile thumbnailFile;
}
