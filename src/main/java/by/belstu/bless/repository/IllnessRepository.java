package by.belstu.bless.repository;

import by.belstu.bless.model.Illness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllnessRepository extends CrudRepository<Illness, Long> {

    List<Illness> findByTag(String tag);

}
