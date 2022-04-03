package pl.bartoszsredzinski.flashcardservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartoszsredzinski.flashcardservice.dto.request.FlashcardSetRequest;
import pl.bartoszsredzinski.flashcardservice.exception.BadIdException;
import pl.bartoszsredzinski.flashcardservice.exception.UniqueFieldException;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.repository.FlashcardSetRepository;

import java.util.Date;
import java.util.List;

/**
 * Flashcard set service
 *
 * @author Bartosz Średziński
 * created on 01.04.2022
 */
@Service
public class FlashcardSetService{

    private final FlashcardSetRepository flashcardSetRepository;

    public FlashcardSetService(FlashcardSetRepository flashcardSetRepository){
        this.flashcardSetRepository = flashcardSetRepository;
    }

    public List<FlashcardSet> getAllSets(){
        return flashcardSetRepository.findAll();
    }

    @Transactional
    public void insertNewFlashcardSet(FlashcardSetRequest flashcardSetRequest){
        if(flashcardSetRepository.findByName(flashcardSetRequest.getName()).isPresent()){
            throw new UniqueFieldException("Name must be unique");
        }
        flashcardSetRepository.insert(mapToFlashcardSet(flashcardSetRequest));
    }

    private FlashcardSet mapToFlashcardSet(FlashcardSetRequest flashcardSetRequest){
        return FlashcardSet.builder()
                .name(flashcardSetRequest.getName())
                .author(flashcardSetRequest.getAuthor())
                .topic(flashcardSetRequest.getTopic())
                .description(flashcardSetRequest.getDescription())
                .flashcards(flashcardSetRequest.getFlashcards())
                .updatedDate(new Date(System.currentTimeMillis()))
                .build();
    }

    @Transactional
    public void updateSet(FlashcardSetRequest flashcardSetRequest, String id){
        if(id == null || flashcardSetRepository.findById(id).isEmpty()){
            throw new BadIdException("Wrong ID, ID is null or incorrect");
        }

        FlashcardSet set = mapToFlashcardSet(flashcardSetRequest);
        set.setId(id);
        flashcardSetRepository.save(set);
    }

    @Transactional
    public void deleteSet(String id){
        flashcardSetRepository.deleteById(id);
    }
}
