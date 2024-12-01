package br.univille.microservsecretaria.aluno.entity;

import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "endereco", autoCreateContainer = true)
public class Endereco extends BaseEntity {

    private String rua;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
