package com.example.ThinkOn.Home.Controller;


import com.example.ThinkOn.Home.Models.Users;
import com.example.ThinkOn.Home.Services.UserServices;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class UsersController {
    @Autowired
    private UserServices userservice ;

    @PostMapping ("/adduser")
    public ResponseEntity<Users> addUsers(@RequestBody Users user)
    {
        ResponseEntity<Users> entity = new ResponseEntity<>(userservice.addUser(user),HttpStatus.CREATED);
        return entity;
    }



    @GetMapping("/user")
    @ResponseBody
    public ResponseEntity<Users> getUser(@RequestParam  String id) {

        Optional<Users> foundUser = userservice.getUser(id) ;
        if (foundUser.isPresent())
        {
            ResponseEntity<Users> entity = new ResponseEntity<>(foundUser.get(),HttpStatus.FOUND);
            return entity;
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }

    @GetMapping("/allUsers")
    @ResponseBody
    public ResponseEntity<List<Users>> getAllUsers() {
        ResponseEntity<List<Users>> entity = new ResponseEntity<>(userservice.getAllUsers(),HttpStatus.OK);
        return entity;
    }


    @PutMapping("/updateUser")
    @ResponseBody
    public ResponseEntity<Users> updateUser(@RequestParam String id , @RequestBody Map<String, Object> userAttribute)
    {

            ResponseEntity<Users> entity = new ResponseEntity<>(userservice.updateUser(id , userAttribute),HttpStatus.OK);
            return entity;
    }


    @DeleteMapping("/deleteUser")
    @ResponseBody
    public ResponseEntity<Users> deleteUser(@RequestParam String id)
    {

        userservice.deleteUser(id);
        ResponseEntity<Users> entity = new ResponseEntity<>(null,HttpStatus.OK);
        return entity;
    }

}
