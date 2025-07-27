package com.example.demo_security_db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    DemoUserService demoUserService;

    @GetMapping("/user")
    public String getUser(@RequestParam("name") String name){

//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        User user = (User) authentication.getPrincipal();
        return "hello " + name;
    }

    @GetMapping("/user/data")
    public String getUserData(@RequestParam("name") String name){

//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        User user = (User) authentication.getPrincipal();
        return "hello " + name;
    }


    @GetMapping("/user-by-email")
    public String getUserByEmail(@RequestParam("email") String email){
        return "hello " + email;
    }

    @GetMapping("/student")
    public String getStudent(){
        return "Hello student";
    }

    @GetMapping("/librarian")
    public String getLibrarian(){
        return "Hello librarian";
    }

    /**
     * 1. Driver -- /user/signup  {FE --> BE request header / param -- application-name = uber-driver}
     * 2. Rider -- /user/signup   {FE --> BE request header / param -- application-name = uber-rider}
     */


    /**
     * 1. Driver -- /user/driver/signup {FE --> make an API call to /user/driver/signup}
     * 2. Rider -- /user/rider/signup  {FE --> make an API call to user/rider/signup}
     */


    /**
     * 1. Driver -- /user/signup  {FE --> name, pwd, type of user ? from the end user}
     * 2. Rider -- /user/signup  {FE --> name, pwd, type of user ? from the end user}
     */



    @PostMapping("/user/student/signup")
    public DemoUser createUser(@RequestParam("user") String user,
                               @RequestParam("pwd") String pwd){

        return demoUserService.createStudent(user, pwd);
    }

//    @PostMapping("/user/librarian/signup")
//    public DemoUser createUser(@RequestParam("user") String user,
//                               @RequestParam("pwd") String pwd){
//
//    }
}
