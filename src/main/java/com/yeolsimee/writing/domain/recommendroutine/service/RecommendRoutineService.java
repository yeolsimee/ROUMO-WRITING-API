package com.yeolsimee.writing.domain.recommendroutine.service;

import com.yeolsimee.writing.domain.recommendimage.service.RecommendImageService;
import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import com.yeolsimee.writing.domain.recommendroutine.repository.RecommendRoutineRepository;
import com.yeolsimee.writing.web.recommendroutine.dto.InsertRecommendRoutineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecommendRoutineService {

    private final RecommendRoutineRepository recommendRoutineRepository;
	private final RecommendImageService recommendImageService;

    public Page<RecommendRoutine> findAll(Pageable pageable) {
        return recommendRoutineRepository.findAll(pageable);
    }

	@Transactional
	public RecommendRoutine createRecommendRoutine(InsertRecommendRoutineDto insertRecommendRoutineDto) throws IOException {
		RecommendRoutine recommendRoutine = new RecommendRoutine(insertRecommendRoutineDto.getSiteUrl());
		recommendImageService.saveRecommendImage(recommendRoutine,insertRecommendRoutineDto.getThumbnailFile());
		return recommendRoutine;
	}
}
