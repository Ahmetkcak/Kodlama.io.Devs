package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;


@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}



	@Override
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageRepository.findAll();
	}

}
