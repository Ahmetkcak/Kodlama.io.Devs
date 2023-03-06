package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.core.mappers.ModelMapperService;
import Kodlama.io.Devs.dataAccess.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();

        List<GetAllProgrammingLanguageResponse> response =  programmingLanguages.stream().map(programmingLanguage -> this.modelMapperService.forResponse().map(programmingLanguage, GetAllProgrammingLanguageResponse.class)).collect(Collectors.toList());

        return response;
    }
}
