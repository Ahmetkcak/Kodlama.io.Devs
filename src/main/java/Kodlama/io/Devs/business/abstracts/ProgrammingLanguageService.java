package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.business.responses.GetAllProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguageResponse> getAll();
}
