package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
		super();
		this.technologyRepository = technologyRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		var technologyToDelete = this.technologyRepository.getById(deleteTechnologyRequest.getId());
		this.technologyRepository.delete(technologyToDelete);
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		var technologyToUpdate = this.technologyRepository.getById(updateTechnologyRequest.getId());
		technologyToUpdate.setName(updateTechnologyRequest.getName());
		this.technologyRepository.save(technologyToUpdate);
		
	}

	@Override
	public List<Technology> getAll() {
		return this.technologyRepository.findAll();
	}

}
