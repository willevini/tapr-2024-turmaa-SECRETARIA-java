package br.univille.microservsecretaria.aluno.mapper;

import br.univille.microservsecretaria.aluno.dto.AlunoDTO;
import br.univille.microservsecretaria.aluno.entity.Aluno;

public class AlunoMapper {

    public static AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setMatricula(aluno.getMatricula());
        dto.setNome(aluno.getNome());
        dto.setDataNascimento(aluno.getDataNascimento());
        dto.setCpf(aluno.getCpf());
        dto.setRua(aluno.getRua());
        dto.setNumero(aluno.getNumero());
        dto.setComplemento(aluno.getComplemento());
        dto.setBairro(aluno.getBairro());
        dto.setCidade(aluno.getCidade());
        dto.setEstado(aluno.getEstado());
        dto.setCep(aluno.getCep());
        return dto;
    }

    public static Aluno toEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(dto.getMatricula());
        aluno.setNome(dto.getNome());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setCpf(dto.getCpf());
        aluno.setRua(dto.getRua());
        aluno.setNumero(dto.getNumero());
        aluno.setComplemento(dto.getComplemento());
        aluno.setBairro(dto.getBairro());
        aluno.setCidade(dto.getCidade());
        aluno.setEstado(dto.getEstado());
        aluno.setCep(dto.getCep());
        return aluno;
    }
}