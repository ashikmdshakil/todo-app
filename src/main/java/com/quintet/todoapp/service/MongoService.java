package com.quintet.todoapp.service;

import org.bson.types.ObjectId;

public class MongoService {
    public static String generateId(){
        return new ObjectId().toString();
    }
}
