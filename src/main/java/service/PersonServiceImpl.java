package service;

import dal.PersonRepository;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Spring Data MongoDb API implementation starts.
     * This exactly the same as MySQL implementation, or any other database to say.
     */

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(String id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person editPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(String id) {
        personRepository.delete(id);
    }

    /**
     * Spring Data MongoDb API implementation ends.
     */

    /**
     * Mongo Template implementation starts.
     */

    @Override
    public Person savePersonTemplate(Person person) {
        return null;
    }

    @Override
    public Person getPersonTemplate(String id) {
        return null;
    }

    @Override
    public Person editPersonTemplate(Person person) {
        return null;
    }

    @Override
    public void deletePersonTemplate(String id) {

    }
}
