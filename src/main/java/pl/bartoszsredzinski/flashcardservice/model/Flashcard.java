package pl.bartoszsredzinski.flashcardservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Flashcard model
 *
 * @author Bartosz Średziński
 * created on 27.03.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Flashcard")
public class Flashcard{
    @Id
    private Long id;

    private String question;
    private String answer;
}
