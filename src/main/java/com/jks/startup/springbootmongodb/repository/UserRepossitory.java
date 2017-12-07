package com.jks.startup.springbootmongodb.repository;

import com.jks.startup.springbootmongodb.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.Resource;

@Resource
public interface UserRepossitory extends MongoRepository <Users, Integer>{
}
