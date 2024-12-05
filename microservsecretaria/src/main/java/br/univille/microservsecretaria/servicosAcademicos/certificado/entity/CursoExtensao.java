package br.univille.microservsecretaria.servicosAcademicos.certificado.entity;

import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "cursoExtensao", autoCreateContainer = true)
public class CursoExtensao extends BaseEntity {

    private String nome;

    private String codigo;
}
