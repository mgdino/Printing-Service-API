package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long>
{

}
