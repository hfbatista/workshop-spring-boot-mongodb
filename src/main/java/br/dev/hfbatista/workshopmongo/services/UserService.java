package br.dev.hfbatista.workshopmongo.services;

import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.repositories.UserRepository;
import br.dev.hfbatista.workshopmongo.excepitions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(String id) {
         Optional<UserEntity> user = this.userRepository.findById(id);
         return user.orElseThrow(() -> new ObjectNotFoundException("Este usuário não existe!!"));
    }
}
