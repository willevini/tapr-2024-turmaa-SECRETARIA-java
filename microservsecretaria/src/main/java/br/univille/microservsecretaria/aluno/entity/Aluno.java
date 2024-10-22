package br.univille.microservsecretaria.aluno.entity;

import java.util.UUID;

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
    private UUID id; 

    private String name;

}
