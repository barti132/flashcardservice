package pl.bartoszsredzinski.flashcardservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartoszsredzinski.flashcardservice.dto.request.AddSetToUserRequest;
import pl.bartoszsredzinski.flashcardservice.dto.request.UserRequest;
import pl.bartoszsredzinski.flashcardservice.exception.BadIdException;
import pl.bartoszsredzinski.flashcardservice.exception.UniqueFieldException;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.model.User;
import pl.bartoszsredzinski.flashcardservice.repository.FlashcardSetRepository;
import pl.bartoszsredzinski.flashcardservice.repository.UserRepository;

import java.util.HashSet;

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
    private final FlashcardSetRepository flashcardSetRepository;

    @Transactional
    public void insertNewUser(UserRequest userRequest){
        if(userRepository.findByUsername(userRequest.getUsername()).isPresent()){
            throw new UniqueFieldException("Username must be unique");
        }

        userRepository.insert(createUser(userRequest.getUsername(), userRequest.getPassword()));
    }

    //TODO encrypt the password
    private User createUser(String username, String password){
        return User.builder().username(username).password(password).role("USER").sets(new HashSet<>()).build();
    }

    @Transactional
    public void addSetToUser(AddSetToUserRequest addSetToUserRequest, String id){
        User user = userRepository.findById(id).orElseThrow(() -> new BadIdException("User " + id + " not found"));
        FlashcardSet set = flashcardSetRepository.findById(addSetToUserRequest.getId())
                .orElseThrow(() -> new BadIdException("Set " + addSetToUserRequest.getId() + " not found"));
        user.getSets().add(set);
        userRepository.save(user);
    }
}
