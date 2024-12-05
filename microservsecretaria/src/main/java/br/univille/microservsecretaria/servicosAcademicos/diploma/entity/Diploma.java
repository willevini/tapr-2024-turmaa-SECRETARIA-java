package br.univille.microservsecretaria.servicosAcademicos.diploma.entity;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.comum.BaseEntity;
import br.univille.microservsecretaria.comum.entity.Curso;
import br.univille.microservsecretaria.servicosAcademicos.diploma.enums.TipoDiploma;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "diploma", autoCreateContainer = true)
public class Diploma extends BaseEntity {

    private Aluno aluno;

    private String instituicaoEnsino;

    private Curso curso;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataConclusao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataEmissao;

    private TipoDiploma tipoDiploma;

    private Double mediaTotalFinal;
}
