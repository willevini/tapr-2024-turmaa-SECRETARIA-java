package br.univille.microservsecretaria.servicosAcademicos.certificado.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CertificadoDto {

    @NotNull(message = "Matrícula do aluno não pode ser nulo")
    private String matriculaAluno;

    @NotNull(message = "Código do curso de extensão não pode ser nulo")
    private String codigoCursoExtensao;

    @NotNull(message = "Data de Emissão não pode ser nula")
    private LocalDateTime dataEmissao;

    @NotNull(message = "Título não pode ser nulo")
    private String titulo;

    @NotNull(message = "Descrição não pode ser nulo")
    private String descricao;

    @NotNull(message = "Carga horária não pode ser nulo")
    private Integer cargaHoraria;
}