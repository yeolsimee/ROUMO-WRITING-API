package com.yeolsimee.writing.domain.recommendroutine.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ArticleContent {
	private String subheading;
	private String contentBody;
}
