package br.univille.microservsecretaria.servicosAcademicos.certificado.service;

import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.Certificado;

import java.util.List;

public interface CertificadoService {
    List<Certificado> getAll();
    Certificado save(Certificado certificado);
    Certificado update(String id, Certificado certificado);
    Certificado delete(String id);
}
