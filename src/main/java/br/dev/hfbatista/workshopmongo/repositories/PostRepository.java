package br.dev.hfbatista.workshopmongo.repositories;

import br.dev.hfbatista.workshopmongo.models.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository  extends MongoRepository<PostEntity, String> {
}
