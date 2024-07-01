package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	@Query(value ="SELECT * FROM product p WHERE p.product_id = ?1", nativeQuery = true)
	public Product findByProductId(Long product_id);
}
