package br.univille.microservsecretaria.servicosAcademicos.certificado.entity;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "certificado", autoCreateContainer = true)
public class Certificado extends BaseEntity {

    @NotNull
    private Aluno aluno;

    private CursoExtensao cursoExtensao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataEmissao;

    private String titulo;

    private String descricao;

    private Integer cargaHoraria;
}
