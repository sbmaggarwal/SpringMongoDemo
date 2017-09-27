package service;

import model.Person;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
public interface PersonService {

    //Below impl will use Spring Data MongoDB API to perform DB operations
    Person savePerson(Person person);
    Person getPerson(String id);
    Person editPerson(Person person);
    void deletePerson(String id);

    //Below impl will use MongoTemplate to perform DB operations
    Person savePersonTemplate(Person person);
    Person getPersonTemplate(String id);
    Person editPersonTemplate(Person person);
    void deletePersonTemplate(String id);
}