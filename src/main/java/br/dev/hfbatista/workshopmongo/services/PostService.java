package br.dev.hfbatista.workshopmongo.services;

import br.dev.hfbatista.workshopmongo.models.PostEntity;
import br.dev.hfbatista.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<PostEntity> findAllPosts() {
        return postRepository.findAll();
    }
}
