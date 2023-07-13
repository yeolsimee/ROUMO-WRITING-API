package com.yeolsimee.writing.domain.recommendroutine.service;

import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendImage;
import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import com.yeolsimee.writing.domain.recommendroutine.repository.RecommendRoutineRepository;
import com.yeolsimee.writing.infra.AmazonS3Service;
import com.yeolsimee.writing.infra.UploadFile;
import com.yeolsimee.writing.web.recommendroutine.dto.InsertRecommendRoutineDto;
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
public class RecommendRoutineService {

    private final RecommendRoutineRepository recommendRoutineRepository;
	private final AmazonS3Service amazonS3Service;

    public Page<RecommendRoutine> findAll(Pageable pageable) {
        return recommendRoutineRepository.findAll(pageable);
    }

	@Transactional
	public RecommendRoutine createRecommendRoutine(InsertRecommendRoutineDto insertRecommendRoutineDto) throws IOException {
		RecommendImage recommendImage = saveRecommendImage(insertRecommendRoutineDto.getThumbnailFile());
		RecommendRoutine recommendRoutine = new RecommendRoutine(insertRecommendRoutineDto.getSiteUrl(), recommendImage);
		RecommendRoutine savedRecommendRoutine = recommendRoutineRepository.save(recommendRoutine);
		return savedRecommendRoutine;
	}

	@Transactional
	public RecommendImage saveRecommendImage(MultipartFile recommendImageFile) {

		UploadFile uploadFile = amazonS3Service.uploadFile("recommendroutine", recommendImageFile);

		String storeFileName = uploadFile != null ? uploadFile.getUploadFileName() : "";
		String imageUrl = uploadFile != null ? uploadFile.getUploadFileUrl() : "";
		String originalFilename = uploadFile != null ? uploadFile.getOriginalFileName() : "";

		RecommendImage recommendImage = new RecommendImage(storeFileName, imageUrl, originalFilename);

		return recommendImage;
	}
}
