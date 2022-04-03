package pl.bartoszsredzinski.flashcardservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.bartoszsredzinski.flashcardservice.dto.request.AddSetToUserRequest;
import pl.bartoszsredzinski.flashcardservice.dto.request.UserRequest;
import pl.bartoszsredzinski.flashcardservice.exception.BadIdException;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.model.User;
import pl.bartoszsredzinski.flashcardservice.repository.FlashcardSetRepository;
import pl.bartoszsredzinski.flashcardservice.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest{

    @Mock
    private UserRepository userRepository;

    @Mock
    private FlashcardSetRepository flashcardSetRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void insertNewUser_should_add_new_user_to_db(){
        when(userRepository.findByUsername("name")).thenReturn(Optional.empty());

        userService.insertNewUser(new UserRequest("name", "pass"));

        verify(userRepository, times(1)).insert(any(User.class));
    }

    @Test
    public void addSetToUser_should_add_set(){
        when(userRepository.findById("abc")).thenReturn(
                Optional.of(User.builder().username("name").password("pass").sets(new HashSet<>()).build()));
        when(flashcardSetRepository.findById("abc1")).thenReturn(Optional.ofNullable(FlashcardSet.builder().name("name").build()));

        userService.addSetToUser(new AddSetToUserRequest("abc1"), "abc");

        verify(userRepository, times(1)).findById("abc");
        verify(userRepository, times(1)).save(any(User.class));
        verify(flashcardSetRepository, times(1)).findById("abc1");
    }

    @Test
    public void addSetToUser_should_throw_exception_for_wrong_user(){
        when(userRepository.findById("abc")).thenReturn(
                Optional.of(User.builder().username("name").password("pass").sets(new HashSet<>()).build()));
        when(flashcardSetRepository.findById("abc1")).thenReturn(Optional.ofNullable(FlashcardSet.builder().name("name").build()));

        assertThrows(BadIdException.class, () -> userService.addSetToUser( new AddSetToUserRequest("abc"), "abc1"));
    }

    @Test
    public void addSetToUser_should_throw_exception_for_wrong_set(){
        when(userRepository.findById("abc")).thenReturn(
                Optional.of(User.builder().username("name").password("pass").sets(new HashSet<>()).build()));
        when(flashcardSetRepository.findById("abc1")).thenReturn(Optional.ofNullable(FlashcardSet.builder().name("name").build()));

        assertThrows(BadIdException.class, () -> userService.addSetToUser( new AddSetToUserRequest("abc2"), "abc"));
    }
}