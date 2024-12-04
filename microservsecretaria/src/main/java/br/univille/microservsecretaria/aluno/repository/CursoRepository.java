package br.univille.microservsecretaria.aluno.repository;

import br.univille.microservsecretaria.aluno.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, String> {

    Curso findByCodigo(String codigo);
}