package edu.sirojga.dictionary.rest.api.repository;

import edu.sirojga.dictionary.rest.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {
    public Optional<User> findById(String id);
    public Optional<User> findByEmail(String email);
}
