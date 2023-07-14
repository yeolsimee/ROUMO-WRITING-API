package com.yeolsimee.writing.web.main.service;

import com.yeolsimee.writing.domain.recommendroutine.entity.Article;
import com.yeolsimee.writing.domain.recommendroutine.service.ArticleService;
import com.yeolsimee.writing.web.main.dto.MainArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainService {

    private final ArticleService articleService;

    public Page<MainArticleDto> getPageMainArticleDtos(Pageable pageable) {
        Page<Article> recommendRoutines = articleService.findAll(pageable);

        return recommendRoutines.map(MainArticleDto::fromRecommendRoutine);
    }
}
