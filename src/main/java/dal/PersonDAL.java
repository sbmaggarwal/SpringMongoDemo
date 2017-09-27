package dal;

import model.Person;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
public interface PersonDAL {

    Person savePersonTemplate(Person person);
    Person getPersonTemplate(String id);
    Person editPersonTemplate(Person person);
    void deletePersonTemplate(String id);
}
