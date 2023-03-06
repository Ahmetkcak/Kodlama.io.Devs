package Kodlama.io.Devs.dataAccess;

import Kodlama.io.Devs.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {
}
