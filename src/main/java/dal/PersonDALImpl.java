package dal;

import com.mongodb.WriteResult;
import model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
@Repository
public class PersonDALImpl implements PersonDAL {

    public static final Logger LOG = LoggerFactory.getLogger(PersonDALImpl.class);

    private MongoTemplate mongoTemplate;

    @Autowired
    public PersonDALImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Person savePersonTemplate(Person person) {

        //save person object
        //populate ID field as well in original object
        mongoTemplate.save(person);
        return person;
    }

    @Override
    public Person getPersonTemplate(String id) {

        Query query = new Query();
        //Criteria is each WHERE clause
        query.addCriteria(Criteria.where("_id").is(id));

        //Person.class provide help to mongoTemplate so that it can convert Object to correct data-type
        Person person = mongoTemplate.findOne(query, Person.class);

        return person;
    }

    @Override
    public Person editPersonTemplate(Person person) {
        //update person object
        //here, ID field is already present
        mongoTemplate.save(person);
        return person;
    }

    @Override
    public void deletePersonTemplate(String id) {
        Query query = new Query();
        //Criteria is each WHERE clause
        query.addCriteria(Criteria.where("_id").is(id));

        //Removes all the objects matching the criteria
        WriteResult writeResult = mongoTemplate.remove(query, Person.class);

        //getN returns how many rows were affected
        LOG.info("{} person(s) were removed from Database", writeResult.getN());

        //removes a single object
        //mongoTemplate.findAndRemove(query, Person.class);
    }
}
