package br.univille.microservsecretaria.comum;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @PartitionKey
    @GeneratedValue
    @Schema(hidden = true)
    private String id;

    @CreatedDate
    @Schema(hidden = true)
    private Date dataCriacao;

    @LastModifiedDate
    @Schema(hidden = true)
    private Date dataAtualizacao;

    @Schema(hidden = true)
    private Long versao = 0L;
}
