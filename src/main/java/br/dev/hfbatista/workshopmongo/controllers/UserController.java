package br.dev.hfbatista.workshopmongo.controllers;


import br.dev.hfbatista.workshopmongo.models.UserDTO;
import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<UserEntity> list = userService.findAllUsers();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserEntity user = userService.findUserById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
}
