package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entity.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long>{
	@Query(value ="SELECT * FROM location l WHERE l.location_name = ?1", nativeQuery = true)
	public Location findByLocationName(String location_name);
}
