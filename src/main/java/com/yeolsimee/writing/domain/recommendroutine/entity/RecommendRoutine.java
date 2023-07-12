package com.yeolsimee.writing.domain.recommendroutine.entity;

import com.yeolsimee.writing.domain.recommendimage.entity.RecommendImage;
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
	@OneToOne
	@JoinColumn(name = "recommend_image_id")
	private RecommendImage recommendImage;

	public RecommendRoutine(String siteUrl, RecommendImage recommendImage) {
		this.siteUrl = siteUrl;
		this.recommendImage = recommendImage;
	}

	public RecommendRoutine(String siteUrl) {
		this.siteUrl = siteUrl;
	}
}
