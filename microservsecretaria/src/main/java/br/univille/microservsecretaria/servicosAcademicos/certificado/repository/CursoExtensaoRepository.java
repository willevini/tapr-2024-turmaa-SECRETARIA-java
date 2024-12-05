package br.univille.microservsecretaria.servicosAcademicos.certificado.repository;

import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.CursoExtensao;
import org.springframework.data.repository.CrudRepository;

public interface CursoExtensaoRepository extends CrudRepository<CursoExtensao, String> {

    CursoExtensao findByCodigo(String codigo);
}
