package br.dev.hfbatista.workshopmongo.excepitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


}
