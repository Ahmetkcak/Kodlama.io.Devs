package kodlama.io.devs.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController()
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	
	@GetMapping("getall")
	public List<ProgrammingLanguage> getAll(){
		return this.programmingLanguageService.getAll();
	}
}
