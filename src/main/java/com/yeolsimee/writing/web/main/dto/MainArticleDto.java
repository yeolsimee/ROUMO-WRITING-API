package com.yeolsimee.writing.web.main.dto;

import com.yeolsimee.writing.domain.article.entity.Article;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainArticleDto {

    private Long articleId;
    private String siteUrl;
    private String thumbnailUrl;

    public static MainArticleDto fromRecommendRoutine(Article article) {
        return MainArticleDto.builder()
                .articleId(article.getId())
                .siteUrl(article.getSiteUrl())
                .thumbnailUrl(article.getArticleImage().getImageUrl())
                .build();
    }
}
