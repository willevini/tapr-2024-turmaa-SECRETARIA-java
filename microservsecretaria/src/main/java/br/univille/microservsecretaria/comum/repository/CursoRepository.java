package br.univille.microservsecretaria.comum.repository;

import br.univille.microservsecretaria.comum.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, String> {

    Curso findByCodigo(String codigo);
}