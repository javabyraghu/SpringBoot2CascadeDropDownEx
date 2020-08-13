package in.nareshit.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
