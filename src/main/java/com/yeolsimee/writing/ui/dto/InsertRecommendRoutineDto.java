package com.yeolsimee.writing.ui.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InsertRecommendRoutineDto {
	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String siteUrl;
	private MultipartFile thumbnailFile;
}
