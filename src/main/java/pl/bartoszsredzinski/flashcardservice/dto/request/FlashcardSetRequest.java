package pl.bartoszsredzinski.flashcardservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.bartoszsredzinski.flashcardservice.model.Flashcard;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Flashcard set request model
 *
 * @author Bartosz Średziński
 * created on 01.04.2022
 */
@Data
@AllArgsConstructor
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
