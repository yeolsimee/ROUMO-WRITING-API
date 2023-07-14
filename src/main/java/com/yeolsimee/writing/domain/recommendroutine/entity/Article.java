package com.yeolsimee.writing.domain.recommendroutine.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private ArticleType articleType;
	private String siteUrl;
	private String articleTitle;
	private String articleSubject;
	private String articleSubSubject;
	@ElementCollection
	private List<ArticleContent> articleContents = new ArrayList<>();
	@ElementCollection
	private List<String> articleRecommendRoutines = new ArrayList<>();
	@Embedded
	private ArticleImage articleImage;

	public Article(String siteUrl, ArticleImage articleImage) {
		this.siteUrl = siteUrl;
		this.articleImage = articleImage;
	}
}
