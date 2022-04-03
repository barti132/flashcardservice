package pl.bartoszsredzinski.flashcardservice.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pl.bartoszsredzinski.flashcardservice.dto.request.FlashcardSetRequest;
import pl.bartoszsredzinski.flashcardservice.service.FlashcardSetService;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Bartosz Średziński
 * created on 03.04.2022
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(OutputCaptureExtension.class)
class FlashcardSetControllerTest{

    @MockBean
    FlashcardSetService flashcardSetService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFlashcards_should_return_all_sets(CapturedOutput out) throws Exception{
        mockMvc.perform(get("/api/v1/flashcard-sets")).andExpect(status().is2xxSuccessful());
        assertTrue(out.getOut().contains("GET flashcard-sets"));
    }

    @Test
    public void addFlashcardSet_should_return_status_2xx(CapturedOutput out) throws Exception{
        FlashcardSetRequest requestBody = new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<>());
        mockMvc.perform(post("/api/v1/flashcard-sets").content(mapper.writeValueAsString(requestBody))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());


        assertTrue(out.getOut().contains("POST flashcard-sets"));
    }

    @Test
    public void updateFlashcardSet_should_return_status_2xx(CapturedOutput out) throws Exception{
        FlashcardSetRequest requestBody = new FlashcardSetRequest("name", "I", "topic", "desc", new HashSet<>());
        mockMvc.perform(put("/api/v1/flashcard-sets/abc").content(mapper.writeValueAsString(requestBody))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());


        assertTrue(out.getOut().contains("PUT flashcard-sets/abc"));
    }

    @Test
    public void deleteFlashcardSet_should_return_status_2xx(CapturedOutput out) throws Exception{
        mockMvc.perform(delete("/api/v1/flashcard-sets/abc")).andExpect(status().is2xxSuccessful());
        assertTrue(out.getOut().contains("DELETE flashcard-sets/abc"));
    }

}