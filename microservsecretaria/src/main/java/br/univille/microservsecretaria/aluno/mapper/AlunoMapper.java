package br.univille.microservsecretaria.aluno.mapper;

import br.univille.microservsecretaria.aluno.dto.AlunoDTO;
import br.univille.microservsecretaria.aluno.entity.Aluno;

public class AlunoMapper {

    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setMatricula(aluno.getMatricula());
        dto.setNome(aluno.getNome());
        dto.setDataNascimento(aluno.getDataNascimento());
        dto.setEndereco(aluno.getEndereco());
        dto.setCpf(aluno.getCpf());
        return dto;
    }

    public static Aluno toEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(dto.getMatricula());
        aluno.setNome(dto.getNome());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setEndereco(dto.getEndereco());
        aluno.setCpf(dto.getCpf());
        return aluno;
    }
}