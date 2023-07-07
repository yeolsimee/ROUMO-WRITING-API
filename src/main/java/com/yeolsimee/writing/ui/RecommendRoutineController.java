package com.yeolsimee.writing.ui;

import com.yeolsimee.writing.ui.dto.InsertRecommendRoutineDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecommendRoutineController {

	@GetMapping("/recommendroutine")
	public String getRecommendRoutineForm(Model model) {
		model.addAttribute("insertRecommendRoutineDto", new InsertRecommendRoutineDto());
		return "recommendroutine/registerform";
	}

	@PostMapping("/recommendroutine")
	public String createRecommendRoutine(Model model) {
		//todo: 추천루틴 생성 로직

		return "recommendroutine/registerform";
	}
}
