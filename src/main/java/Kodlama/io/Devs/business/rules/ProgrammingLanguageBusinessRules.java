package Kodlama.io.Devs.business.rules;

import Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Kodlama.io.Devs.dataAccess.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {
    private ProgrammingLanguageRepository programmingLanguageRepository;
    public void checkIfProgrammingLanguageNameExist(String name){
        if(this.programmingLanguageRepository.existsByName(name)){
            throw new BusinessException("Programming language name already exists");
        }
    }
}
