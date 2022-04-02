package pl.bartoszsredzinski.flashcardservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class description
 *
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UniqueFieldException extends RuntimeException{
    public UniqueFieldException(String message){
        super(message);
    }
}
