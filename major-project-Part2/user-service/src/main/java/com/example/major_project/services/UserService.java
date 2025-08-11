package com.example.major_project.services;

import com.example.major_project.dto.CreateUserDTO;
import com.example.major_project.models.User;
import com.example.major_project.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final String USER_CREATED_TOPIC = "user-created";
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public User create(CreateUserDTO createUserDTO){
        User user = this.userRepository.save(createUserDTO.toUser());
        try {
            String data = objectMapper.writeValueAsString(user);

            logger.info("data to be published - {}", data);
            this.kafkaTemplate.send(USER_CREATED_TOPIC, data);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return user;
    }
}
