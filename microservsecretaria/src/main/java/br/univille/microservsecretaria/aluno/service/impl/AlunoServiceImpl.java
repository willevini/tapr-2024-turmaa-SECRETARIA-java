package br.univille.microservsecretaria.aluno.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Aluno update(String id, Aluno aluno) {
        Optional<Aluno> alunoDB = repository.findById(id);
        if (!alunoDB.isPresent()) return null;

        Aluno alunoAtual = alunoDB.get();
        alunoAtual.setNome(aluno.getNome());
        repository.save(alunoAtual);

        return alunoAtual;
    }

    @Override
    public Aluno delete(String id) {
        Optional<Aluno> alunoDB = repository.findById(id);
        if (!alunoDB.isPresent()) return null;

        repository.delete(alunoDB.get());
        return alunoDB.get();
    }
}
