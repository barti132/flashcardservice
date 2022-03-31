package pl.bartoszsredzinski.flashcardservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;

import java.util.Optional;

/**
 * Flashcard set mongo repository
 *
 * @author Bartosz Średziński
 * created on 31.03.2022
 */
public interface FlashcardSetRepository extends MongoRepository<FlashcardSet, String>{
    Optional<FlashcardSet> findByName(String name);
}
