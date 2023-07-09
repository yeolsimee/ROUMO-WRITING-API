package com.yeolsimee.writing.web.main.dto;

import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainRecommendRoutineDto {

    private Long recommendRoutineId;
    private String siteUrl;
    private String thumbnailUrl;

    public static MainRecommendRoutineDto fromRecommendRoutine(RecommendRoutine recommendRoutine) {
        return MainRecommendRoutineDto.builder()
                .recommendRoutineId(recommendRoutine.getId())
                .siteUrl(recommendRoutine.getSiteUrl())
                .thumbnailUrl(recommendRoutine.getThumbnailUrl())
                .build();
    }
}
