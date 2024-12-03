package br.univille.microservsecretaria.aluno.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AlunoDTO {

    @NotNull(message = "Matrícula não pode ser nula")
    @Size(min = 5, max = 20, message = "Matrícula deve ter entre 5 e 20 caracteres")
    private String matricula;

    @NotNull(message = "Curso não pode ser nulo")
    private CursoDTO cursoDTO;

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "Data de Nascimento não pode ser nula")
    private Date dataNascimento;

    @NotNull(message = "CPF não pode ser nulo")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
    private String cpf;

    @NotNull(message = "Rua não pode ser nula")
    @Size(min = 2, max = 100, message = "Rua deve ter entre 2 e 100 caracteres")
    private String rua;

    @NotNull(message = "Número não pode ser nulo")
    private String numero;

    @NotNull(message = "Cidade não pode ser nula")
    @Size(min = 2, max = 100, message = "Cidade deve ter entre 2 e 100 caracteres")
    private String cidade;

    @NotNull(message = "Estado não pode ser nulo")
    @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String estado;

    @NotNull(message = "CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    private String bairro;

    @NotNull(message = "CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    private String cep;

    @Size(min = 1, max = 100, message = "Complemento deve ter no máximo 100 caracteres")
    private String complemento;
}