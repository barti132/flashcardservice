package pl.bartoszsredzinski.flashcardservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Flashcard model
 *
 * @author Bartosz Średziński
 * created on 27.03.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flashcard{
    private String question;
    private String answer;
}
