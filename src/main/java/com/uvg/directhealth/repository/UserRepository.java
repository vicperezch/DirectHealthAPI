package com.uvg.directhealth.repository;

import com.uvg.directhealth.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
