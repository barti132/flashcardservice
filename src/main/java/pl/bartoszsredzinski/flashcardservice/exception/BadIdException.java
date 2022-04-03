package pl.bartoszsredzinski.flashcardservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Bad id runtime exception
 *
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadIdException extends RuntimeException{
    public BadIdException(String message){
        super(message);
    }
}
