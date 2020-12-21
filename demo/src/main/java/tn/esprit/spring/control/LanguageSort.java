package tn.esprit.spring.control;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DTO.Word;
import tn.esprit.spring.service.LanguageService;

@RestController
public class LanguageSort {
	
	private final LanguageService languageService;
	
	private LanguageSort(LanguageService languageService) {
		this.languageService = languageService;
	}	
	
	
	@GetMapping("/words")
	public List<Word> fetchWords(@RequestParam String language) throws IOException {
		return this.languageService.findWords(language);
	}
	
	@GetMapping("/first-ten-words")
	public List<Word> fetchFirstTenWords(@RequestParam String language) throws IOException {
		return this.languageService.findFirstTenWords(language);
	}
	
	

}
