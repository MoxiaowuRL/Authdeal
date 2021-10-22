package flagcamp.authdeal.repository;

import flagcamp.authdeal.entity.Messages;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessagesRepository extends CrudRepository<Messages, Integer> {
  @Query(value = "SELECT messages FROM Messages messages Where messages.from.userName=:user Or messages.to.userName=:user")
  List<Messages> findAllMessagesOfUser(@Param("user") String userId);
}
