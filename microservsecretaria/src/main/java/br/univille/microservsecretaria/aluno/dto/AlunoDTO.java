package br.univille.microservsecretaria.aluno.dto;

import br.univille.microservsecretaria.aluno.entity.Endereco;
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

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "Data de Nascimento não pode ser nula")
    private Date dataNascimento;

    @NotNull(message = "Endereço não pode ser nulo")
    private Endereco endereco;

    @NotNull(message = "CPF não pode ser nulo")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
    private String cpf;
}