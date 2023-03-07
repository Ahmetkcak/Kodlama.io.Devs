package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.business.rules.ProgrammingLanguageBusinessRules;
import Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
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
    private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;
    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();

        List<GetAllProgrammingLanguageResponse> response =  programmingLanguages.stream().map(programmingLanguage -> this.modelMapperService.forResponse().map(programmingLanguage, GetAllProgrammingLanguageResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage programmingLanguages = this.programmingLanguageRepository.findById(id).orElseThrow();
        GetByIdProgrammingLanguageResponse response = this.modelMapperService.forResponse().map(programmingLanguages, GetByIdProgrammingLanguageResponse.class);
        return response;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        this.programmingLanguageBusinessRules.checkIfProgrammingLanguageNameExist(createProgrammingLanguageRequest.getName());
        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest,ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        this.programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest,ProgrammingLanguage.class);
        this.programmingLanguageRepository.save(programmingLanguage);
    }
}
