package edu.sirojga.dictionary.rest.api.repository;

import edu.sirojga.dictionary.rest.api.model.UserDictionaries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserDictionaryRepo extends MongoRepository<UserDictionaries, String> {

    @Query("{ '_id' : ?0 }")
    UserDictionaries test(String name);
}
