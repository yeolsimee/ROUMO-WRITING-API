package com.yeolsimee.writing.domain.recommendroutine.repository;

import com.yeolsimee.writing.domain.recommendroutine.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
