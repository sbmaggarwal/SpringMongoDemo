package dal;

import model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
