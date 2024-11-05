package br.univille.microservsecretaria.aluno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.aluno.repository.AlunoRepository;
import br.univille.microservsecretaria.aluno.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public List<Aluno> getAll() {
        Iterable<Aluno> alunos = repository.findAll();
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        alunos.forEach(listaAlunos::add);
        return listaAlunos;
    }

    @Override
    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }
}
