package com.yeolsimee.writing.web.article.controller;

import com.yeolsimee.writing.domain.article.entity.Article;
import com.yeolsimee.writing.domain.article.service.ArticleService;
import com.yeolsimee.writing.web.article.dto.InsertArticleDto;
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
public class ArticleController {

	private final ArticleService articleService;

	@GetMapping("/article")
	public String getArticleForm(Model model) {
		model.addAttribute("insertArticleDto", new InsertArticleDto());
		return "article/articleform";
	}
	@GetMapping("/externalarticle")
	public String getExternalArticleForm(Model model) {
		model.addAttribute("insertArticleDto", new InsertArticleDto());
		return "article/externalarticleform";
	}

	@PostMapping("/article")
	public String createArticleRoutine(@Validated @ModelAttribute("insertArticleDto") InsertArticleDto insertArticleDto,
	                                     BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		try {
			Article savedArticle = articleService.createRecommendRoutine(insertArticleDto);
			redirectAttributes.addAttribute("itemId", savedArticle.getId());
		} catch (Exception e) {
			log.error(e.getMessage());
			bindingResult.reject("globalError", "기사 등록 중 에러가 발생하였습니다.");
			return "article/articleform";
		}

		return "redirect:/";
	}
}
