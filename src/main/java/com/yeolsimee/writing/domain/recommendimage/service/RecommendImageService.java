package com.yeolsimee.writing.domain.recommendimage.service;

import com.yeolsimee.writing.domain.recommendimage.entity.RecommendImage;
import com.yeolsimee.writing.domain.recommendimage.repository.RecommendImageRepository;
import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import com.yeolsimee.writing.infra.AmazonS3Service;
import com.yeolsimee.writing.infra.UploadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecommendImageService {

	private final AmazonS3Service amazonS3Service;
	private final RecommendImageRepository recommendImageRepository;

	@Transactional
	public void saveRecommendImage(RecommendRoutine recommendRoutine, MultipartFile recommendImageFile) throws IOException {

		UploadFile uploadFile = amazonS3Service.uploadFile("recommendroutine", recommendImageFile);

		String storeFileName = uploadFile != null ? uploadFile.getUploadFileName() : "";
		String imageUrl = uploadFile != null ? uploadFile.getUploadFileUrl() : "";
		String originalFilename = uploadFile != null ? uploadFile.getOriginalFileName() : "";

		RecommendImage recommendImage = new RecommendImage(storeFileName, imageUrl, originalFilename);

		RecommendImage saveRecommendImage = RecommendImage.createRecommendImage(recommendImage, recommendRoutine);
		recommendImageRepository.save(saveRecommendImage);
	}
}
