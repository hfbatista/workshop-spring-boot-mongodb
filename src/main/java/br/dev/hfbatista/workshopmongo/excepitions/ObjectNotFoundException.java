package br.dev.hfbatista.workshopmongo.excepitions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException (String message) {
        super(message);
    }

}
