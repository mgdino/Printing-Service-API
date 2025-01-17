package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
