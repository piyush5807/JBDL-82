package com.example.demo_beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service // @Component
@Scope("prototype")
public class TestService {

    // singleton --> prototype (as many number of times, this object is required to be injected, those many number of instances are created)

    // TestController - t1 (TestService)
    // OtherController - t1 (TestService)
    // DemoController - t1 (TestService)

    // TestController - t1
    // OtherController - t2
    // DemoController - t3

    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

//    @Override
//    public String toString() {
//        return "TestService{" +
//                "serviceName='" + serviceName + '\'' +
//                '}';
//    }

    public void setServiceName(String service_name) {
        this.serviceName = service_name;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        TestService.logger = logger;
    }

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    public TestService() {
        logger.info("Inside TestService: object - {}", this);
    }



    public Person createPerson(Integer id, String name){

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }
}
