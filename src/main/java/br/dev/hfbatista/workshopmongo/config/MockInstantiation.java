package br.dev.hfbatista.workshopmongo.config;


import br.dev.hfbatista.workshopmongo.models.PostEntity;
import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.repositories.PostRepository;
import br.dev.hfbatista.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class MockInstantiation implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");
        UserEntity jane = new UserEntity(null, "Jane Smith", "jane@gmail.com");
        UserEntity john = new UserEntity(null, "John Doe", "john@gmail.com");

        PostEntity post1 = new PostEntity(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", bob);
        PostEntity post2 = new PostEntity(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", bob);

        userRepository.saveAll(Arrays.asList(bob, john, jane));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
