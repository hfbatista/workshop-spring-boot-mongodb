package br.dev.hfbatista.workshopmongo.config;

import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MockInstantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
        UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
        UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
        UserEntity jane = new UserEntity(null, "Jane Smith", "jane@gmail.com");
        UserEntity john = new UserEntity(null, "John Doe", "john@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, john, jane));
    }
}
