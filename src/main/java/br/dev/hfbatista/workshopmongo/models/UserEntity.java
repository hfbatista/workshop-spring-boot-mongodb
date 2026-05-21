package br.dev.hfbatista.workshopmongo.models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cUsers")
public class UserEntity implements Serializable {

    @Id
    private ObjectId _id;

    private String name;
    private String email;
}
