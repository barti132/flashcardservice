package pl.bartoszsredzinski.flashcardservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.bartoszsredzinski.flashcardservice.model.Flashcard;
import pl.bartoszsredzinski.flashcardservice.model.FlashcardSet;
import pl.bartoszsredzinski.flashcardservice.repository.FlashcardSetRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class FlashcardserviceApplication{

    public static void main(String[] args){
        SpringApplication.run(FlashcardserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(FlashcardSetRepository repository){
        return args -> {
            FlashcardSet flashcardSet = FlashcardSet.builder()
                    .author("Bartosz Średziński")
                    .topic("IT")
                    .description("Short set about IT")
                    .updatedDate(new Date(System.currentTimeMillis()))
                    .flashcards(new HashSet<>(
                            Arrays.asList(new Flashcard("What is JVM?", "JVM is an acronym for Java Virtual Machine"),
                                    new Flashcard("What is JRE?", "JRE stands for Java Runtime Environment."))))
                    .build();

            repository.insert(flashcardSet);
            FlashcardSet flashcardSet1 = FlashcardSet.builder()
                    .author("Bartosz Średziński")
                    .topic("IT")
                    .description("Another flashcards set about IT")
                    .updatedDate(new Date(System.currentTimeMillis()))
                    .flashcards(new HashSet<>(
                            Arrays.asList(new Flashcard("What is JVM?", "JVM is an acronym for Java Virtual Machine"),
                                    new Flashcard("What is JRE?", "JRE stands for Java Runtime Environment."))))
                    .build();
            repository.insert(flashcardSet1);
        };
    }
}
