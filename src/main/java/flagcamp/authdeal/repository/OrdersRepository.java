package flagcamp.authdeal.repository;

import flagcamp.authdeal.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
  @Query(value = "SELECT order FROM Orders order Where order.buyer.userName=:user")
  List<Orders> findAllOrdersOfBuyer(@Param("user") String userId);
  @Query(value = "SELECT order FROM Orders order Where order.seller.userName=:user")
  List<Orders> findAllOrdersOfSeller(@Param("user") String userId);
}
