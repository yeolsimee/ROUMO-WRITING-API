package com.yeolsimee.writing.domain.article.service;

import com.yeolsimee.writing.domain.article.entity.Article;
import com.yeolsimee.writing.domain.article.entity.ArticleImage;
import com.yeolsimee.writing.domain.article.repository.ArticleRepository;
import com.yeolsimee.writing.infra.AmazonS3Service;
import com.yeolsimee.writing.infra.UploadFile;
import com.yeolsimee.writing.web.article.dto.InsertCommonArticleDto;
import com.yeolsimee.writing.web.article.dto.InsertExternalArticleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;
	private final AmazonS3Service amazonS3Service;

    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

	@Transactional
	public Article createCommonArticle(InsertCommonArticleDto insertCommonArticleDto) throws IOException {
		ArticleImage articleImage = saveRecommendImage(insertCommonArticleDto.getThumbnailFile());
		Article article = Article.createCommonArticle(InsertCommonArticleDto.toEntity(insertCommonArticleDto, articleImage));
		Article savedArticle = articleRepository.save(article);
		return savedArticle;
	}

	@Transactional
	public Article createExternalArticle(InsertExternalArticleDto insertExternalArticleDto) throws IOException {
		ArticleImage articleImage = saveRecommendImage(insertExternalArticleDto.getThumbnailFile());

		Article article = Article.createExternalArticle(InsertExternalArticleDto.toEntity(insertExternalArticleDto, articleImage));
		Article savedArticle = articleRepository.save(article);
		return savedArticle;
	}

	@Transactional
	public ArticleImage saveRecommendImage(MultipartFile recommendImageFile) {

		UploadFile uploadFile = amazonS3Service.uploadFile("recommendroutine", recommendImageFile);

		String storeFileName = uploadFile != null ? uploadFile.getUploadFileName() : "";
		String imageUrl = uploadFile != null ? uploadFile.getUploadFileUrl() : "";
		String originalFilename = uploadFile != null ? uploadFile.getOriginalFileName() : "";

		ArticleImage articleImage = new ArticleImage(storeFileName, imageUrl, originalFilename);

		return articleImage;
	}
}
