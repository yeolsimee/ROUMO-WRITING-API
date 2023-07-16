package com.yeolsimee.writing.domain.article.repository;

import com.yeolsimee.writing.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
