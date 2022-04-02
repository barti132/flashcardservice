package pl.bartoszsredzinski.flashcardservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.bartoszsredzinski.flashcardservice.model.User;

import java.util.Optional;

/**
 * User mongo repository
 *
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findByUsername(String username);
}
