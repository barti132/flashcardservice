package pl.bartoszsredzinski.flashcardservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.bartoszsredzinski.flashcardservice.model.Flashcard;

/**
 * Flashcard mongo repository
 *
 * @author Bartosz Średziński
 * created on 27.03.2022
 */
public interface FlashcardRepository extends MongoRepository<Flashcard, Long>{
}
