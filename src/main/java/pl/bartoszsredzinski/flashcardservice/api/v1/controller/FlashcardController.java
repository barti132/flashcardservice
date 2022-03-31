package pl.bartoszsredzinski.flashcardservice.api.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.bartoszsredzinski.flashcardservice.model.Flashcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Flashcard rest controller
 *
 * @author Bartosz Średziński
 * created on 27.03.2022
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/flashcards")
public class FlashcardController{

    @GetMapping("")
    public List<Flashcard> getFlashcards(){
        log.info("GET flashcards");
        return new ArrayList<>();
    }

    @PostMapping("")
    public void addFlashcard(@RequestBody Flashcard flashcard){
        log.info("POST flashcards");
    }
}
