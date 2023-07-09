package com.yeolsimee.writing.web.main.controller;

import com.yeolsimee.writing.web.main.dto.MainRecommendRoutineDto;
import com.yeolsimee.writing.web.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String main(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<MainRecommendRoutineDto> pageMainRecommendRoutineDto = mainService.getPageMainRecommendRoutineDtos(PageRequest.of(page, 6));
        model.addAttribute("recommendRoutineDto", pageMainRecommendRoutineDto);
        model.addAttribute("maxPage", 5); // 메인페이지에 노출되는 최대 페이지 갯수
        return "main/mainpage";
    }
}
