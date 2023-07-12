package com.yeolsimee.writing.domain.recommendimage.entity;

import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imageName;
	private String imageUrl;
	private String originalImageName;

	@OneToOne
	@JoinColumn(name = "recommend_routine_id")
	private RecommendRoutine recommendRoutine;

	public RecommendImage(String imageName, String imageUrl, String originalImageName) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.originalImageName = originalImageName;
	}

	@Builder
	public RecommendImage(String imageName, String imageUrl, String originalImageName, RecommendRoutine recommendRoutine) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.originalImageName = originalImageName;
		this.recommendRoutine = recommendRoutine;
	}

	public static RecommendImage createRecommendImage(RecommendImage recommendImage, RecommendRoutine recommendRoutine) {
		return RecommendImage.builder()
				.imageName(recommendImage.imageName)
				.imageUrl(recommendImage.imageUrl)
				.originalImageName(recommendImage.originalImageName)
				.recommendRoutine(recommendRoutine)
				.build();
	}
}
