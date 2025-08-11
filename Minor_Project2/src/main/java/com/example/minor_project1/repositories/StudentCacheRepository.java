package com.example.minor_project1.repositories;

import com.example.minor_project1.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCacheRepository {

    private static final String STUDENT_CACHE_KEY_PREFIX = "student::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void create(Student student){

        this.redisTemplate.opsForValue().set(getCacheKey(student.getId()), student);
    }

    public Student get(Integer id){
        return (Student) this.redisTemplate.opsForValue().get(getCacheKey(id));
    }

    private String getCacheKey(Integer id){
        return STUDENT_CACHE_KEY_PREFIX + id;
    }
}
