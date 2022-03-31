package pl.bartoszsredzinski.flashcardservice.dto.request;

import lombok.Data;
import pl.bartoszsredzinski.flashcardservice.model.Flashcard;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Flashcard set request model
 *
 * @author Bartosz Średziński
 * created on 01.04.2022
 */
@Data
public class FlashcardSetRequest{

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @NotBlank
    private String topic;

    @NotBlank
    private String description;

    @NotNull
    private Set<Flashcard> flashcards;
}
