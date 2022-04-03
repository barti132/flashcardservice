package pl.bartoszsredzinski.flashcardservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.bartoszsredzinski.flashcardservice.dto.request.UserRequest;
import pl.bartoszsredzinski.flashcardservice.model.User;
import pl.bartoszsredzinski.flashcardservice.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest{

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @Test
    public void insertNewUser_should_add_new_user_to_db(){
        when(repository.findByUsername("name")).thenReturn(Optional.empty());

        userService.insertNewUser(new UserRequest("name", "pass"));

        verify(repository, times(1)).insert(any(User.class));
    }
}