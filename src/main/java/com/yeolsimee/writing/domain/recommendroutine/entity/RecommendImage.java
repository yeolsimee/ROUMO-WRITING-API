package com.yeolsimee.writing.domain.recommendroutine.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class RecommendImage {
	private String imageName;
	private String imageUrl;
	private String originalImageName;


	public RecommendImage(String imageName, String imageUrl, String originalImageName) {
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.originalImageName = originalImageName;
	}
}
