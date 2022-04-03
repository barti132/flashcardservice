package pl.bartoszsredzinski.flashcardservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Request with set id
 *
 * @author Bartosz Średziński
 * created on 04.04.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSetToUserRequest{
    @NotBlank
    private String id;
}
