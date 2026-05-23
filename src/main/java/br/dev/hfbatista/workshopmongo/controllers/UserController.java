package br.dev.hfbatista.workshopmongo.controllers;


import br.dev.hfbatista.workshopmongo.models.UserDTO;
import br.dev.hfbatista.workshopmongo.models.UserEntity;
import br.dev.hfbatista.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> inserUser(@RequestBody UserDTO userDTO) {
        UserEntity user = this.userService.fromDTO(userDTO);
        user = this.userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
