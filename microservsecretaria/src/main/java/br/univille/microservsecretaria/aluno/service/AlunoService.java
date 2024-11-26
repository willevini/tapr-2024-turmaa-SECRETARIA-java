package br.univille.microservsecretaria.aluno.service;

import java.util.List;

import br.univille.microservsecretaria.aluno.entity.Aluno;

public interface AlunoService {
    
    List<Aluno> getAll();
    Aluno save(Aluno aluno);
    Aluno update(String id, Aluno aluno);
    Aluno delete(String id);
}
