package br.univille.microservsecretaria.comum;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
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

    public BaseEntity() {
        this.versao += 1;
    }

    @Id
    @PartitionKey
    @GeneratedValue
    @Schema(hidden = true)
    private String id;

    @CreatedDate
    private Date dataCriacao;

    @LastModifiedDate
    private Date ultimaAtualizacao;

    @Version
    private String versao;
}
