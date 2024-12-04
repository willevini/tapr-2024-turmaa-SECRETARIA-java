package br.univille.microservsecretaria.comum;

import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Schema(hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dataAtualizacao;

    @Schema(hidden = true)
    private Long versao = 0L;
}
