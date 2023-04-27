package pl.aleh.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aleh.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

  Optional<Person> findByFullName(String fullName);
}
