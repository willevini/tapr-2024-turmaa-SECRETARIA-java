package br.univille.microservsecretaria.comum.entity;

import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "curso", autoCreateContainer = true)
public class Curso extends BaseEntity {

    private String nome;

    private String codigo;
}