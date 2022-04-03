package pl.bartoszsredzinski.flashcardservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartoszsredzinski.flashcardservice.dto.request.UserRequest;
import pl.bartoszsredzinski.flashcardservice.exception.UniqueFieldException;
import pl.bartoszsredzinski.flashcardservice.model.User;
import pl.bartoszsredzinski.flashcardservice.repository.UserRepository;

/**
 * User service
 *
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    @Transactional
    public void insertNewUser(UserRequest userRequest){
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            throw new UniqueFieldException("Username must be unique");
        }

        userRepository.insert(mapToUser(userRequest));
    }

    //TODO encrypt the password
    private User mapToUser(UserRequest userRequest){
        return User.builder().username(userRequest.getUsername()).password(userRequest.getPassword()).role("USER").build();
    }
}
