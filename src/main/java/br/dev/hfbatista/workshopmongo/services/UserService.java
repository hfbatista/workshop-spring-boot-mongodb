package br.dev.hfbatista.workshopmongo.services;

import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
