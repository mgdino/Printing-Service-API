package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Long>{

}
