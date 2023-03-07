package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.business.requests.CreateLanguageTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguageTechnologyResponse;

import java.util.List;

public interface LanguageTechnologyService {
    List<GetAllLanguageTechnologyResponse> getAll();

    void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);
}
