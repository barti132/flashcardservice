package pl.bartoszsredzinski.flashcardservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

/**
 * Flashcard set model
 *
 * @author Bartosz Średziński
 * created on 31.03.2022
 */

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlashcardSet{

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String author;
    private String topic;
    private String description;
    private Date updatedDate;
    private Set<Flashcard> flashcards;
}
