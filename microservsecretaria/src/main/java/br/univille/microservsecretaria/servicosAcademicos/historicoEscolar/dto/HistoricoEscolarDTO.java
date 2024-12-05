package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.dto;


import br.univille.microservsecretaria.comum.entity.Curso;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoricoEscolarDTO {

    @NotNull(message = "Curso não pode ser nulo")
    @Size(min = 0, max = 10, message = "Média geral deve estar entre 0 e 10")
    private Double mediaGeral;

    @NotNull(message = "Curso não pode ser nulo")
    @Size(min = 75, max = 100, message = "Frequência geral deve estar entre 75 e 100")
    private Double frequenciaGeral;

    @NotNull(message = "Situação não pode ser nulo")
    private Boolean situacaoFinal;

    @NotNull(message = "Data de emissão não pode ser nula")
    private LocalDateTime dataEmissao;

    @NotNull(message = "Instituição não pode ser nula")
    private String instituicao;

    @NotNull(message = "Periodo não pode ser nula")
    private String periodo;

    @NotNull(message = "Curso não pode ser nula")
    private Curso curso;
}
