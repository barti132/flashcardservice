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
                    .name("set 1")
                    .author("Bartosz Średziński")
                    .topic("IT")
                    .description("Short set about IT")
                    .updatedDate(new Date(System.currentTimeMillis()))
                    .flashcards(new HashSet<>(Arrays.asList(Flashcard.builder()
                            .question("What is JVM?")
                            .answer("JVM is an acronym for Java Virtual Machine")
                            .isWriteable(false)
                            .build(), Flashcard.builder()
                            .question("What is JRE?")
                            .answer("JRE stands for Java Runtime Environment.")
                            .isWriteable(false)
                            .build())))
                    .build();

            if(repository.findByName("set 1").isEmpty()){
                repository.save(flashcardSet);
            }
            FlashcardSet flashcardSet1 = FlashcardSet.builder()
                    .name("set 2")
                    .author("Bartosz Średziński")
                    .topic("IT")
                    .description("Another flashcards set about IT")
                    .updatedDate(new Date(System.currentTimeMillis()))
                    .flashcards(new HashSet<>(Arrays.asList(Flashcard.builder()
                            .question("What is JVM?")
                            .answer("JVM is an acronym for Java Virtual Machine")
                            .isWriteable(false)
                            .build(), Flashcard.builder()
                            .question("What is JRE?")
                            .answer("JRE stands for Java Runtime Environment.")
                            .isWriteable(false)
                            .build())))
                    .build();
            if(repository.findByName("set 2").isEmpty()){
                repository.save(flashcardSet1);
            }
        };
    }
}
