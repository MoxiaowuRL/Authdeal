package flagcamp.authdeal.repository;


import flagcamp.authdeal.entity.Items;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemsRepository extends CrudRepository<Items, Integer> {
  @Query(value = "SELECT items FROM Items items Where items.users.userName=:seller")
  List<Items> findAllItemsOfSeller(@Param("seller") String seller);
}
