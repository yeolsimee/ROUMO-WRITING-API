package com.yeolsimee.writing.domain.article.entity;

import com.yeolsimee.writing.web.article.dto.InsertCommonArticleDto;
import com.yeolsimee.writing.web.article.dto.InsertExternalArticleDto;
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
	private String articleIntroduction;
	@ElementCollection
	private List<ArticleContent> articleContents = new ArrayList<>();
	@ElementCollection
	private List<String> articleRecommendRoutines = new ArrayList<>();
	@Embedded
	private ArticleImage articleImage;

	@Builder
	public Article(ArticleType articleType, String siteUrl, String articleTitle, String articleSubject, String articleSubSubject, String articleIntroduction, List<ArticleContent> articleContents, List<String> articleRecommendRoutines, ArticleImage articleImage) {
		this.articleType = articleType;
		this.siteUrl = siteUrl;
		this.articleTitle = articleTitle;
		this.articleSubject = articleSubject;
		this.articleSubSubject = articleSubSubject;
		this.articleIntroduction = articleIntroduction;
		this.articleContents = articleContents;
		this.articleRecommendRoutines = articleRecommendRoutines;
		this.articleImage = articleImage;
	}

	public static Article createCommonArticle(Article commonArticle){
		return Article.builder()
				.articleType(commonArticle.getArticleType())
				.articleTitle(commonArticle.getArticleTitle())
				.articleSubject(commonArticle.getArticleSubject())
				.articleImage(commonArticle.getArticleImage())
				.articleSubSubject(commonArticle.getArticleSubSubject())
				.articleIntroduction(commonArticle.getArticleIntroduction())
				.articleContents(commonArticle.getArticleContents())
				.articleRecommendRoutines(commonArticle.getArticleRecommendRoutines())
				.build();
	}

	public static Article createExternalArticle(Article externalArticle){
		return Article.builder()
				.articleType(externalArticle.getArticleType())
				.siteUrl(externalArticle.getSiteUrl())
				.build();
	}
}
