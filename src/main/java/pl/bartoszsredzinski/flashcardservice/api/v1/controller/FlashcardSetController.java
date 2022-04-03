package pl.bartoszsredzinski.flashcardservice.api.v1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.bartoszsredzinski.flashcardservice.dto.request.FlashcardSetRequest;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.service.FlashcardSetService;

import javax.validation.Valid;
import java.util.List;

/**
 * Flashcard set rest controller
 *
 * @author Bartosz Średziński
 * created on 01.04.2022
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/flashcard-sets")
public class FlashcardSetController{

    private final FlashcardSetService flashcardSetService;

    public FlashcardSetController(FlashcardSetService flashcardSetService){
        this.flashcardSetService = flashcardSetService;
    }

    @GetMapping("")
    public List<FlashcardSet> getFlashcards(){
        log.info("GET flashcard-sets");
        return flashcardSetService.findAllSets();
    }

    @PostMapping("")
    public void addFlashcardSet(@Valid @RequestBody FlashcardSetRequest flashcardSetRequest){
        log.info("POST flashcard-sets");
        flashcardSetService.insertNewFlashcardSet(flashcardSetRequest);
    }

    @GetMapping("/{id}")
    public FlashcardSet getFlashcardSet(@PathVariable String id){
        log.info("GET flashcard-sets/" + id);
        return flashcardSetService.findSet(id);
    }

    @PutMapping("/{id}")
    public void updateFlashcardSet(@Valid @RequestBody FlashcardSetRequest flashcardSetRequest, @PathVariable String id){
        log.info("PUT flashcard-sets/" + id);
        flashcardSetService.updateSet(flashcardSetRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlashcardSet(@PathVariable String id){
        log.info("DELETE flashcard-sets/" + id);
        flashcardSetService.deleteSet(id);
    }
}
