package com.example.demo_beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@ResponseBody // adds a view resolver which basically converts all the java objects being returned from a class to a json / some other understandable object notation.
public class TestController {

    // Autowired annotation symbolizes dependency injection
    /**
     * Inject / attach the object created by spring during the application startup with this variable in this class
     */

    @Autowired
    private TestService testService;
//    private TestService testService = new TestService();

    // RestController = Controller + ResponseBody

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    TestController(){
        logger.info("Inside testController constructor, this - {}", this);
    }

    /**
     * Annotations[] annotations = reflection.getAllAnnotations(TestController.greet)
     * if(annotation.isInstanceOf(GetMapping.class)){
     *
     * }
     *
     *
     * @param name
     * @return
     */

    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam("name") String name){
        logger.info("Inside greet function, name - {}", name);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test-key", "test-value");
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hello + " + name + "!!!", httpHeaders, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/person-details")
    public ResponseEntity<Person> getDetails(@RequestParam("id") int id, @RequestParam("name") String name){

//        Person person = new Person(); // this object is created manually by the developer not by spring boot during the application startup
//        person.setId(id);
//        person.setName(name);

        logger.info("Request received to get person details, testService - {}, id - {}, name - {}", this.testService, id, name);

        Person person = testService.createPerson(id, name);

        this.testService.setServiceName("test");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test-key", "test-value");
        ResponseEntity<Person> responseEntity = new ResponseEntity<>(person, httpHeaders, HttpStatus.ACCEPTED);
        return responseEntity;
    }

    // com.example.demo_beans.TestController@33db72bd

    // com.example.demo_beans.TestController@33db72bd

    // com.example.demo_beans.TestController@64412d34 - constructor
    // com.example.demo_beans.TestController@64412d34 - greet
    // com.example.demo_beans.TestController@64412d34 - greet2


    // Creating shared instance of singleton bean 'testController'
    // Bean is nothing but a spring boot created object

}
