package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import service.PersonService;

/**
 * @author : Shubham Aggarwal
 * @since : 27/09/17
 */
@RestController
public class PersonController {

    public static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    /**
     * Injecting dependecies using constructor injection
     * as field injection is not recommended.
     *
     * @param personService The service class.
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
}
