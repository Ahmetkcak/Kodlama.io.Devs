package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguageResponse getById(@PathVariable int id){
        return this.programmingLanguageService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.programmingLanguageService.delete(id);
    }


    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping()
    public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
        this.programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        this.programmingLanguageService.update(updateProgrammingLanguageRequest);
    }
}
