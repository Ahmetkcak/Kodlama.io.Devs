package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;
import Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguageResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id);
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
    void delete(int id);

    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);

}
