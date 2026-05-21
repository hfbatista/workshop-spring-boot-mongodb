package br.dev.hfbatista.workshopmongo.controllers;


import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {

        List<UserEntity> list = userService.findAllUsers();
        return ResponseEntity.ok().body(list);
    }
}
