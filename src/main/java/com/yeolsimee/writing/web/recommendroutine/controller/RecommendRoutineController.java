package com.yeolsimee.writing.web.recommendroutine.controller;

import com.yeolsimee.writing.domain.recommendroutine.entity.RecommendRoutine;
import com.yeolsimee.writing.domain.recommendroutine.service.RecommendRoutineService;
import com.yeolsimee.writing.web.recommendroutine.dto.InsertRecommendRoutineDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RecommendRoutineController {

	private final RecommendRoutineService recommendRoutineService;

	@GetMapping("/recommendroutine")
	public String getRecommendRoutineForm(Model model) {
		model.addAttribute("insertRecommendRoutineDto", new InsertRecommendRoutineDto());
		return "recommendroutine/registerform";
	}

	@PostMapping("/recommendroutine")
	public String createRecommendRoutine(@Validated @ModelAttribute("insertRecommendRoutineDto") InsertRecommendRoutineDto insertRecommendRoutineDto,
	                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		try {
			RecommendRoutine savedRecommendRoutine = recommendRoutineService.createRecommendRoutine(insertRecommendRoutineDto);
			redirectAttributes.addAttribute("itemId", savedRecommendRoutine.getId());
		} catch (Exception e) {
			log.error(e.getMessage());
			bindingResult.reject("globalError", "추천 루틴 등록 중 에러가 발생하였습니다.");
			return "recommendroutine/registerform";
		}

		return "redirect:/";
	}
}
