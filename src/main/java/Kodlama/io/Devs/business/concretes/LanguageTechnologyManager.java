package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageTechnologyService;
import Kodlama.io.Devs.business.requests.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageTechnologyResponse;
import Kodlama.io.Devs.core.mappers.ModelMapperService;
import Kodlama.io.Devs.dataAccess.LanguageTechnologyRepository;
import Kodlama.io.Devs.entities.LanguageTechnology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageTechnologyManager implements LanguageTechnologyService {

    private LanguageTechnologyRepository languageTechnologyRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllLanguageTechnologyResponse> getAll() {
        List<LanguageTechnology> languageTechnologies = this.languageTechnologyRepository.findAll();
        List<GetAllLanguageTechnologyResponse> response = languageTechnologies.stream().map(languageTechnology -> this.modelMapperService.forResponse().map(languageTechnology,GetAllLanguageTechnologyResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
        LanguageTechnology languageTechnology = this.modelMapperService.forRequest().map(createLanguageTechnologyRequest,LanguageTechnology.class);
        this.languageTechnologyRepository.save(languageTechnology);
    }
}
