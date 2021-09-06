package com.quintet.todoapp.repository;

import com.quintet.todoapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepo extends MongoRepository<User, Integer> {
    User findByEmail(String email);
}
