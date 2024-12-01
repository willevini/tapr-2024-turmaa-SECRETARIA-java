package br.univille.microservsecretaria.aluno.entity;

import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.EqualsAndHashCode;
import lombok.Data;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "aluno", autoCreateContainer = true)
public class Aluno extends BaseEntity {

    private String matricula;

    private String nome;

    private Date dataNascimento;

    private Endereco endereco;

    private String cpf;
}
