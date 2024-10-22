package br.univille.microservsecretaria.aluno.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.univille.microservsecretaria.aluno.entity.Aluno;

@Repository
public interface AlunoRepository 
    extends CrudRepository<Aluno,String>{
    
}
