package com.example.demo_beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtherController {

    private static Logger logger = LoggerFactory.getLogger(OtherController.class);

//    @Autowired
//    Person person;

    /**
     * 1. Application will fail because auto wiring will not happen
     * 2. Application will start, but the value will be null as it's a static field and no injection will take place, testService will be null
     * 3. Application will start and the dependency will also take place and testService won't be null
     * 4. None of the above
     */

    /**
     * 1. Assigning of any value to the member variable during the declaration
     * 2. Constructor is called
     * 3. All field injections take place
     */

//
//    No autowiring
//    private TestService testService = new TestService();

    @Autowired // this is redundant if you are injecting via constructor injection as well
    private TestService testService;

//    @Value("${my-app.count.value}")
    private Integer count;

    /**
     * 1. OtherController(TestService testService) will be called
     * 2. OtherController(Integer count)
     * 3. Application will fail due to dilemma encountered by spring boot during object creation
     * @param testService
     */

//    @Autowired
//    OtherController(TestService testService){
//        logger.info("Inside constructor... , this.testService - {}", this.testService);
//        this.testService = testService;
//    }

    // How to create a bean of any existing class
    // How to create a bean of primitive data type / wrapper classes (it's like a property)

    OtherController(@Value("${my-app.count.value}") Integer count){
        logger.info("Inside default constructor, ... count - {}", count);
        if(count > 10){
            System.out.println("I am happy");
        }else{
            System.out.println("I am sad");
        }

        this.count = count;
    }

//    OtherController(@Value("${my-app.count.value}") Integer count){
//        this.count = count;
//    }

    /**
     * Parametrized constructor will hide the default constructor of otherController
     * @param name
     * @return
     */


//    private TestService testService = new TestService();

    @GetMapping("/greet2")
    public String greet2(@RequestParam("name") String name){
        logger.info("Inside greet2 function, name - {}, this - {}, testService - {}", name, this, testService);
        this.testService.setServiceName("other");
        return "Hello " + name;
    }

    @PostMapping("/person")
    public void createPerson(@RequestBody PersonCreateRequest personCreateRequest){

        Person person1 = new Person();
        person1.setName(personCreateRequest.getName());
        person1.setId(person1.getId());
    }
}
