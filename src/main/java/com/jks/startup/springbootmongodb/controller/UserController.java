package com.jks.startup.springbootmongodb.controller;

import com.jks.startup.springbootmongodb.document.Users;
import com.jks.startup.springbootmongodb.repository.UserRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-repo")
public class UserController  {

    @Autowired
    private UserRepossitory userRepossitory;

    //Read all - http://localhost:5050/user-repo/all
    @GetMapping("/all")//@RequestMapping(path ="/all",method = RequestMethod.GET)
    public List<Users> getAllUsers(){
        return userRepossitory.findAll();
    }

    //Create - http://localhost:5050/user-repo/user
    @PostMapping(path ="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users create(@RequestBody Users user){
        return userRepossitory.save(user);
    }

    //Read - http://localhost:5050/user-repo/user/100
    @GetMapping(path ="/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users read(@PathVariable Integer id){
        return userRepossitory.findOne(id);
    }

    //Update - http://localhost:5050/user-repo/user
    @PutMapping(path ="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users update(@RequestBody Users user){
        return userRepossitory.save(user);
    }

    //Delete - http://localhost:5050/user-repo/user/100
    @DeleteMapping(path ="/user/{id}")
    public void delete(@PathVariable Integer id){
        userRepossitory.delete(id);
    }

}
