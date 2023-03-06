package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
@AllArgsConstructor
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;


    @GetMapping()
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return this.programmingLanguageService.getAll();
    }
}
