package by.belstu.bless.repository;

import by.belstu.bless.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositiry extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
