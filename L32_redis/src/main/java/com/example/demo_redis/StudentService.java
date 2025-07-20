package com.example.demo_redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final String STUDENT_REDIS_KEY_PREFIX = "student::";

    private String getStudentRedisKey(String studentId){
        return STUDENT_REDIS_KEY_PREFIX + studentId;
    }


    public String create(Student student){
        student.setId(UUID.randomUUID().toString());

        Map studentData = objectMapper.convertValue(student, Map.class);

        redisTemplate.opsForHash().putAll(getStudentRedisKey(student.getId()), studentData);
        return student.getId();
    }

    public Student getById(String studentId){
        Map<Object, Object> map = redisTemplate.opsForHash().entries(getStudentRedisKey(studentId));
        if(map == null || map.size() == 0){
            return null;
        }
        return objectMapper.convertValue(map, Student.class);
    }
}
