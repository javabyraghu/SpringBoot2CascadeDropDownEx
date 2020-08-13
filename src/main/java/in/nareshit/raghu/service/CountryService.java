package in.nareshit.raghu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.repo.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository repo;
	
	public List<Object[]> getAllCountries(){
		return repo.getAllCountries();
	}
	
	public List<Object[]> getStatesByCountry(Integer id){
		return repo.getStatesByCountry(id);
	}
}
