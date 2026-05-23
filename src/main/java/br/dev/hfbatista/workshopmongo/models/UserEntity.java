package br.dev.hfbatista.workshopmongo.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cUsers")
public class UserEntity {

    @Id
    private String id;

    private String name;
    private String email;
}
