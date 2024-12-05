package br.univille.microservsecretaria.servicosAcademicos.diploma.service;

import br.univille.microservsecretaria.servicosAcademicos.diploma.entity.Diploma;

import java.util.List;

public interface DiplomaService {

    List<Diploma> getAll();
    Diploma save(Diploma diploma);
    Diploma update(String id, Diploma diploma);
    Diploma delete(String id);
}
