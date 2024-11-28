package br.univille.microservsecretaria.aluno.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import lombok.Data;

@Data
@Container(containerName = "aluno", autoCreateContainer = true)
public class Aluno {

    @Id
    @PartitionKey
    @GeneratedValue
    @Schema(hidden = true)
    private String id; 

    private String name;
}
