package com.yeolsimee.writing.domain.recommendroutine.service;

import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import com.yeolsimee.writing.domain.recommendroutine.repository.RecommendRoutineRepository;
import com.yeolsimee.writing.web.recommendroutine.dto.InsertRecommendRoutineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecommendRoutineService {

    private final RecommendRoutineRepository recommendRoutineRepository;
    public Page<RecommendRoutine> findAll(Pageable pageable) {
        return recommendRoutineRepository.findAll(pageable);
    }

	@Transactional
	public RecommendRoutine createRecommendRoutine(InsertRecommendRoutineDto insertRecommendRoutineDto) {
		//todo: 추천루틴 생성 로직

		return null;
	}
}
