package in.nareshit.raghu.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.raghu.model.City;
import in.nareshit.raghu.model.Country;
import in.nareshit.raghu.model.State;
import in.nareshit.raghu.repo.CityRepository;
import in.nareshit.raghu.repo.CountryRepository;
import in.nareshit.raghu.repo.StateRepository;

@Component
public class SetupDataRunner implements CommandLineRunner {
	@Autowired
	private CityRepository cirepo;
	@Autowired
	private StateRepository srepo;
	@Autowired
	private CountryRepository cnrepo;
	
	@Override
	public void run(String... args) throws Exception {
		City c1 = new City(101, "Hyderabad");
		City c2 = new City(102, "Warangal");
		
		City c3 = new City(103, "Bengaluru");
		City c4 = new City(104, "Hubli");
		
		City c5 = new City(105, "Los Angeles");
		City c6 = new City(106, "San Francisco");
		
		City c7 = new City(107, "Orlando");
		City c8 = new City(108, "Miami");
		
		cirepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8));
		
		State s1 = new State(201, "Telangana", Set.of(c1,c2));
		State s2 = new State(202, "Karnataka", Set.of(c3,c4));
		
		State s3 = new State(203, "California", Set.of(c5,c6));
		State s4 = new State(204, "Florida", Set.of(c7,c8));
		
		srepo.saveAll(Arrays.asList(s1,s2,s3,s4));
		
		Country cn1 = new Country(301, "India", Set.of(s1,s2));
		Country cn2 = new Country(302, "USA", Set.of(s3,s4));
		
		cnrepo.saveAll(Arrays.asList(cn1,cn2));
		
	}

}
