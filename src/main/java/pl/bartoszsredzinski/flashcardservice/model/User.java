package pl.bartoszsredzinski.flashcardservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User model
 *
 * @author Bartosz Średziński
 * created on 02.04.2022
 */
@Data
@Document
@Builder
public class User{
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private String role;
}
