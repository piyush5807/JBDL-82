package com.example.L18_apis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private static HashMap<Integer, User> userMap = new HashMap<>();

    // string x = "abc"
    // string y = "def"
    // x + y
    // sb = new sb(x); sb.append(y)

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        logger.info("createUser: user data received {}", user);
        userMap.put(user.getId(), user);
        return user;

        // createUser: user data received user.toString(),
    }



    @GetMapping("/user")
    public User getUser(@RequestParam("id") int userId){
        logger.info("getUser: request received id - {}", userId);
        return userMap.get(userId); // 1 Network call to the underlying db
    }

    @GetMapping("/user/all")
    public List<User> getUsers(){
        logger.info("getUser: request received id");
        return userMap.values().stream().collect(Collectors.toList()); // n network calls to the underlying db
    }

    @DeleteMapping("/user/{userId}")
    public User deleteUser(@PathVariable("userId") int id){

        User user = userMap.get(id);
        if(user != null){
            userMap.remove(id);
        }
        return user;

    }

    @PutMapping("/user")
    public User updateUser(@RequestParam("id") int userId, @RequestBody User user){

        userMap.put(userId, user);
        return user;
    }

    // CRUD - create, read, update, delete


    // POST http://localhost:8090/users?id=2
    // POST http://localhost:8090/users


    // Note: You cannot have 2 similar APIs in a server
    // What's the definition of similar APIs: ENDPOINT + REQUEST METHOD combination is same for multiple APIs
}
