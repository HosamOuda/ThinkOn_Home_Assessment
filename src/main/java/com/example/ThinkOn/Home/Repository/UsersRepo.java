package com.example.ThinkOn.Home.Repository;

import com.example.ThinkOn.Home.Models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepo extends MongoRepository<Users,String> {
}
