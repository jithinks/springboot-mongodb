package com.jks.startup.springbootmongodb.config;

import com.jks.startup.springbootmongodb.document.Users;
import com.jks.startup.springbootmongodb.repository.UserRepossitory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepossitory.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner (UserRepossitory userRepossitory){
        return strings -> {
               userRepossitory.save(new Users(100, "Jack", "Team Lead", 10000L));
               userRepossitory.save(new Users(200, "Tom", "Developer", 2000L));
        };

    }
}
