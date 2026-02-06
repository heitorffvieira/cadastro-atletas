package br.com.vieiradev.apiCadastroAtletas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AthleteException extends RuntimeException {
    public AthleteException() {
        super("Atleta não encontrado.");
    }
}
