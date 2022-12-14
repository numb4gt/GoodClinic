package by.belstu.bless.repository;

import by.belstu.bless.model.Illness;
import by.belstu.bless.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllnessRepository extends CrudRepository<Illness, Long> {

    List<Illness> findByTagAndUserfor(String tag, User user);

    List<Illness> findByTagAndUser(String tag, User user);

    List<Illness> findByUser(User user);

    List<Illness> findByUserfor(User user);

}
