package br.univille.microservsecretaria.servicosAcademicos.diploma.repository;

import br.univille.microservsecretaria.servicosAcademicos.diploma.entity.Diploma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaRepository extends CrudRepository<Diploma, String> {
}