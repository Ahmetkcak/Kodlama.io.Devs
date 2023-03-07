package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import Kodlama.io.Devs.business.requests.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageTechnologyResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languageTechnologies")
@AllArgsConstructor
public class LanguageTechnologiesController {

    private LanguageTechnologyService languageTechnologyService;

    @GetMapping()
    public List<GetAllLanguageTechnologyResponse> getAll(){
        return this.languageTechnologyService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void add(@RequestBody @Valid CreateLanguageTechnologyRequest createLanguageTechnologyRequest){
        this.languageTechnologyService.add(createLanguageTechnologyRequest);
    }
}
