package br.univille.microservsecretaria.servicosAcademicos.certificado.repository;

import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.Certificado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends CrudRepository<Certificado, String> {
}
