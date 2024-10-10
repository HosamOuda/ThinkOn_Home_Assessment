package com.example.ThinkOne.Home.Repository;

import com.example.ThinkOne.Home.Models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepo extends MongoRepository<Users,String> {
}
