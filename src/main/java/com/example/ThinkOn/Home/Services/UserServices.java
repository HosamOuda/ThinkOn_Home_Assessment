package com.example.ThinkOn.Home.Services;

import com.example.ThinkOn.Home.Models.Users;
import com.example.ThinkOn.Home.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class UserServices {

    @Autowired
    private UsersRepo userRepo;

    /*
    the function to add a single user to the Mongo database. It saves the user as a document using the save()
    function inhereted from the MongoRepo
     */
    public Users addUser(@RequestBody Users user)
    {
        System.out.println("------------------------------------------");
        return userRepo.save(user);
    }

    public List<Users> getAllUsers()
    {
        return userRepo.findAll();
    }

    public Optional<Users> getUser(String userID)
    {
        return userRepo.findById(userID) ;
    }

    public Users updateUser (String userID , Map<String, Object> userAttributes)
    {
        Optional<Users> targetUser = userRepo.findById(userID);

        if (targetUser.isPresent())
        {
            Users user = targetUser.get();
            for (Map.Entry<String, Object> entry : userAttributes.entrySet()) {
                switch (entry.getKey()) {
                    case "username":
                        user.setUsername(entry.getValue().toString());
                        break;
                    case "firstname":
                        System.out.println("I found a firstname");
                        user.setFirstname(entry.getValue().toString());
                        break;
                    case "lastname":
                        user.setLastname(entry.getValue().toString());
                        break;
                    case "email":
                        user.setEmail(entry.getValue().toString());
                        break;
                    case "phonenumber":
                        user.setPhonenumber(entry.getValue().toString());
                        break;
                }
            }
            return userRepo.save(user);
        }

        return null;

    }

    public void deleteUser(String id) {

        userRepo.deleteById(id);
    }
}
