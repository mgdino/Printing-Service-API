package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entity.OrderStatement;

@Repository
public interface OrderStatementRepo extends JpaRepository<OrderStatement, Long>{
	@Query(value ="SELECT * FROM order_statement o WHERE o.order_id = ?1", nativeQuery = true)
	public OrderStatement findByOrderId(Long order_id);
	
	@Query(value ="SELECT * FROM order_statement o WHERE o.location_id = ?1", nativeQuery = true)
	public List<OrderStatement> findByLocationId(Long location_id);
	
	@Query(value ="SELECT * FROM order_statement o WHERE o.branch_id = ?1", nativeQuery = true)
	public List<OrderStatement> findByBranchId(Long branch_id);
}
