package pl.bartoszsredzinski.flashcardservice.api.v1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartoszsredzinski.flashcardservice.dto.request.UserRequest;
import pl.bartoszsredzinski.flashcardservice.service.UserService;

import javax.validation.Valid;

/**
 * User rest controller
 *
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @PostMapping
    public void registerUser(@Valid @RequestBody UserRequest userRequest){
        log.info("POST users");
        userService.insertNewUser(userRequest);
    }

}
