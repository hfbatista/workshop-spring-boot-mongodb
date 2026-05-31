package br.dev.hfbatista.workshopmongo.controllers;

import br.dev.hfbatista.workshopmongo.models.PostEntity;
import br.dev.hfbatista.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.findAllPosts();
    }
}
