package br.univille.microservsecretaria.comum.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorDetalhes {

    private LocalDateTime timestamp;

    private String mensagem;

    private Map<String, String> detalhes;

    public ErrorDetalhes(LocalDateTime timestamp, String mensagem, Map<String, String> detalhes) {
        this.timestamp = timestamp;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }
}
