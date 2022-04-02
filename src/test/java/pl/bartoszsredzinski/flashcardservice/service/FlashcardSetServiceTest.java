package pl.bartoszsredzinski.flashcardservice.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.bartoszsredzinski.flashcardservice.dto.request.FlashcardSetRequest;
import pl.bartoszsredzinski.flashcardservice.model.Flashcard;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.repository.FlashcardSetRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Bartosz Średziński
 * created on 01.04.2022
 */

@SpringBootTest
@ActiveProfiles("test")
class FlashcardSetServiceTest{

    @Mock
    private FlashcardSetRepository repository;

    @InjectMocks
    private FlashcardSetService flashcardSetService;

    @Test
    public void getAllSets_should_return_all_sets(){
        when(repository.findAll()).thenReturn(Arrays.asList(FlashcardSet.builder().build(), FlashcardSet.builder().build()));

        assertEquals(2, flashcardSetService.getAllSets().size());
    }

    @Test
    public void insertNewFlashcardSet_should_add_new_set(){
        flashcardSetService.insertNewFlashcardSet(
                new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<Flashcard>()));

        verify(repository, times(1)).insert(any(FlashcardSet.class));
    }

    @Test
    public void insertNewFlashcardSet_should_throw_exception(){
        when(repository.findByName(any(String.class))).thenReturn(Optional.of(FlashcardSet.builder().build()));


        assertThrows(RuntimeException.class, ()-> flashcardSetService.insertNewFlashcardSet(
                new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<Flashcard>())));
    }

}