package com.yeolsimee.writing.domain.recommendroutine.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendRoutine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String siteUrl;
	@Embedded
	private RecommendImage recommendImage;

	public RecommendRoutine(String siteUrl, RecommendImage recommendImage) {
		this.siteUrl = siteUrl;
		this.recommendImage = recommendImage;
	}
}
