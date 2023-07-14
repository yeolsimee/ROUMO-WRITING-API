package com.yeolsimee.writing.domain.recommendroutine.service;

import com.yeolsimee.writing.domain.recommendroutine.entity.Article;
import com.yeolsimee.writing.domain.recommendroutine.entity.ArticleImage;
import com.yeolsimee.writing.domain.recommendroutine.repository.ArticleRepository;
import com.yeolsimee.writing.infra.AmazonS3Service;
import com.yeolsimee.writing.infra.UploadFile;
import com.yeolsimee.writing.web.recommendroutine.dto.InsertArticleDto;
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
	public Article createRecommendRoutine(InsertArticleDto insertArticleDto) throws IOException {
		ArticleImage articleImage = saveRecommendImage(insertArticleDto.getThumbnailFile());
		Article article = new Article(insertArticleDto.getSiteUrl(), articleImage);
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
