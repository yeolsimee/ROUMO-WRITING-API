package com.yeolsimee.writing.domain.recommendroutine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendRoutine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String siteUrl;
	private String thumbnailUrl;

	public RecommendRoutine(String siteUrl, String thumbnailUrl) {
		this.siteUrl = siteUrl;
		this.thumbnailUrl = thumbnailUrl;
	}
}
