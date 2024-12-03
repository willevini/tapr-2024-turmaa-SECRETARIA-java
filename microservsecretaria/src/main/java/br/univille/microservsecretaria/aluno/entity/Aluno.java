package br.univille.microservsecretaria.aluno.entity;

import br.univille.microservsecretaria.comum.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Data;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "aluno", autoCreateContainer = true)
public class Aluno extends BaseEntity {

    @Schema(hidden = true)
    private String matricula;

    private Curso curso;

    private String nome;

    private Date dataNascimento;

    private String cpf;

    private String rua;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
