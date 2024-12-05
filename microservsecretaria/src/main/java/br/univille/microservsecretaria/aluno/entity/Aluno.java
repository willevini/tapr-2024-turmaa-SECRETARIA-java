package br.univille.microservsecretaria.aluno.entity;

import br.univille.microservsecretaria.comum.BaseEntity;
import br.univille.microservsecretaria.comum.entity.Curso;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Container(containerName = "aluno", autoCreateContainer = true)
public class Aluno extends BaseEntity {

    @Schema(hidden = true)
    private String matricula;

    private Curso curso;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataNascimento;

    private String cpf;

    private String rua;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
