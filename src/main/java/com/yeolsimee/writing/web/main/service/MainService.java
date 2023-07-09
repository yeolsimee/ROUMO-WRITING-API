package com.yeolsimee.writing.web.main.service;

import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import com.yeolsimee.writing.domain.recommendroutine.service.RecommendRoutineService;
import com.yeolsimee.writing.web.main.dto.MainRecommendRoutineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainService {

    private final RecommendRoutineService recommendRoutineService;

    public Page<MainRecommendRoutineDto> getPageMainRecommendRoutineDtos(Pageable pageable) {
        Page<RecommendRoutine> recommendRoutines = recommendRoutineService.findAll(pageable);

        return recommendRoutines.map(MainRecommendRoutineDto::fromRecommendRoutine);
    }
}
