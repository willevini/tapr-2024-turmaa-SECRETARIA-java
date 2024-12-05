package br.univille.microservsecretaria.servicosAcademicos.diploma.dto;

import br.univille.microservsecretaria.servicosAcademicos.diploma.enums.TipoDiploma;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiplomaUpdateDTO {

    @NotNull(message = "Instituição de ensino é obrigatória")
    private String instituicaoEnsino;

    @NotNull(message = "Data de conclusão é obrigatória")
    private LocalDateTime dataConclusao;

    @NotNull(message = "Data de emissão é obrigatória")
    private LocalDateTime dataEmissao;

    @NotNull(message = "Tipo de diploma é obrigatório")
    private TipoDiploma tipoDiploma;

    @NotNull(message = "Média total final é obrigatória")
    @DecimalMin(value = "0.0", message = "Média total final deve ser maior ou igual a 0")
    @DecimalMax(value = "10.0", message = "Média total final deve ser menor ou igual a 10")
    private Double mediaTotalFinal;
}