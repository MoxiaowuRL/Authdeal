package flagcamp.authdeal.dao;

import flagcamp.authdeal.entity.*;
import flagcamp.authdeal.repository.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
  @Autowired
  UsersRepository usersRepository;

  public void createUsers(Users user) {
    usersRepository.save(user);
  }

  public Users findUserById(String userName) {
    return usersRepository.findById(userName).get();
  }

  public List<Users> findAllUsers() {
    List<Users> result = new ArrayList<>();
    for (Users user : usersRepository.findAll()) {
      result.add(user);
    }
    return result;
  }
}
