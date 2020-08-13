package in.nareshit.raghu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.repo.StateRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository repo; 
	
	public List<Object[]> getCitiesByState(Integer id){
		return repo.getCitiesByState(id);
	}
}
