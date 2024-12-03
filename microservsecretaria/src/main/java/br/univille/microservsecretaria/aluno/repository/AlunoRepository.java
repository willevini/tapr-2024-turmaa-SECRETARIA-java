package br.univille.microservsecretaria.aluno.repository;

import br.univille.microservsecretaria.aluno.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.univille.microservsecretaria.aluno.entity.Aluno;

import java.util.Date;
import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno,String> {

    List<Aluno> findByCursoAndDataCriacaoBetween(Curso curso, Date startDate, Date endDate);
}
