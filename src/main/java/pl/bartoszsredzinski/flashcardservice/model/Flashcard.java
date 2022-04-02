package pl.bartoszsredzinski.flashcardservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Flashcard model
 *
 * @author Bartosz Średziński
 * created on 27.03.2022
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flashcard{
    private String question;
    private String answer;
    private Boolean isWriteable;
    private Integer correct;
    private Integer incorrect;
    private Integer level;
    private Date nextRepetition;
}
