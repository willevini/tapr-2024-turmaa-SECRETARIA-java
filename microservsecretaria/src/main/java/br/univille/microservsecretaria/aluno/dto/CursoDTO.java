package br.univille.microservsecretaria.aluno.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CursoDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;
}
