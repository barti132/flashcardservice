package pl.bartoszsredzinski.flashcardservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Create user model request
 *
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@Data
@AllArgsConstructor
public class UserRequest{

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
