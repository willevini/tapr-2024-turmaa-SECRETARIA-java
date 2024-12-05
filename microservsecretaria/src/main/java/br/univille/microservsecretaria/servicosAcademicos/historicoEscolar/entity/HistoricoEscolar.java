package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.entity;

import br.univille.microservsecretaria.comum.entity.Curso;
import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "historicoEscolar", autoCreateContainer = true)
public class HistoricoEscolar extends BaseEntity {

    private Curso curso;
    private Double mediaGeral;

    private Double frequenciaGeral;

    private Boolean situacaoFinal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataEmissao;

    private String instituicao;

    private String periodo;
}