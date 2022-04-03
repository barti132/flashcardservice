package pl.bartoszsredzinski.flashcardservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.bartoszsredzinski.flashcardservice.dto.request.FlashcardSetRequest;
import pl.bartoszsredzinski.flashcardservice.exception.BadIdException;
import pl.bartoszsredzinski.flashcardservice.exception.UniqueFieldException;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.repository.FlashcardSetRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

        assertEquals(2, flashcardSetService.findAllSets().size());
    }

    @Test
    public void insertNewFlashcardSet_should_add_new_set(){
        flashcardSetService.insertNewFlashcardSet(new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<>()));

        verify(repository, times(1)).insert(any(FlashcardSet.class));
    }

    @Test
    public void insertNewFlashcardSet_should_throw_exception(){
        when(repository.findByName(any(String.class))).thenReturn(Optional.of(FlashcardSet.builder().build()));

        assertThrows(UniqueFieldException.class, () -> flashcardSetService.insertNewFlashcardSet(
                new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<>())));
    }

    @Test
    public void updateSet_should_update_the_set(){
        when(repository.findById("abc")).thenReturn(Optional.of(new FlashcardSet()));

        flashcardSetService.updateSet(new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<>()), "abc");
        verify(repository, times(1)).save(any(FlashcardSet.class));
    }

    @Test
    public void updateSet_should_throw_exception_for_wrong_id(){
        when(repository.findById("abc")).thenReturn(Optional.empty());

        assertThrows(BadIdException.class, () -> flashcardSetService.updateSet(
                new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<>()), "abc"));
    }

    @Test
    public void findSet_should_return_set(){
        when(repository.findById("abc")).thenReturn(Optional.ofNullable(FlashcardSet.builder().name("name").build()));
        assertEquals("name", flashcardSetService.findSet("abc").getName());
        verify(repository, times(1)).findById("abc");
    }

    @Test
    public void findSet_should_throw_exception(){
        when(repository.findById("abc")).thenReturn(Optional.ofNullable(FlashcardSet.builder().name("name").build()));
        assertThrows(BadIdException.class, () -> flashcardSetService.findSet( "abc1"));
    }

}