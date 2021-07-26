package edu.sirojga.dictionary.rest.api.repository;

import edu.sirojga.dictionary.rest.api.model.UserDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDictionaryRepo extends MongoRepository<UserDictionary, String> {
}
