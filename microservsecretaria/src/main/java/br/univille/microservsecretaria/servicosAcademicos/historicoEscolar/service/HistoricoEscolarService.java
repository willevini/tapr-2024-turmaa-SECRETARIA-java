package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.service;


import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.entity.HistoricoEscolar;

import java.util.List;

public interface HistoricoEscolarService {

    List<HistoricoEscolar> getAll();
    HistoricoEscolar save(HistoricoEscolar historicoEscolar);
    HistoricoEscolar update(String id, HistoricoEscolar historicoEscolar);
    HistoricoEscolar delete(String id);
}
