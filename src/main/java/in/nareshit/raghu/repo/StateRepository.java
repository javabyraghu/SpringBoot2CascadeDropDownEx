package in.nareshit.raghu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.raghu.model.State;

public interface StateRepository extends JpaRepository<State, Integer> {

	@Query("SELECT c.id,c.name FROM State s JOIN s.cities AS c WHERE s.id=:id")
	List<Object[]> getCitiesByState(Integer id);
}
