package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.service.impl;

import br.univille.microservsecretaria.aluno.service.MatriculaService;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.entity.HistoricoEscolar;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.repository.HistoricoEscolarRepository;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.service.HistoricoEscolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoEscolarServiceImpl implements HistoricoEscolarService {

    @Autowired
    private HistoricoEscolarRepository repository;

    @Autowired
    private MatriculaService matriculaService;
    @Override
    public List<HistoricoEscolar> getAll() {
        Iterable<HistoricoEscolar> historicosEscolares = repository.findAll();
        ArrayList<HistoricoEscolar> listaHistoricos = new ArrayList<>();
        historicosEscolares.forEach(listaHistoricos::add);
        return listaHistoricos;
    }

    @Override
    public HistoricoEscolar save(HistoricoEscolar historicoEscolar) {
        String matricula = matriculaService.gerarMatricula(historicoEscolar.getCurso());
        historicoEscolar.setId(matricula);
        return repository.save(historicoEscolar);
    }

    @Override
    public HistoricoEscolar update(String id, HistoricoEscolar historicoEscolar) {
        Optional<HistoricoEscolar> historicoEscolarDB = repository.findById(id);
        if (!historicoEscolarDB.isPresent()) return null;

        HistoricoEscolar historicoEscolarAtual = historicoEscolarDB.get();
        historicoEscolar.setCurso(historicoEscolarAtual.getCurso());
        historicoEscolar.setMediaGeral(historicoEscolarAtual.getMediaGeral());
        historicoEscolar.setFrequenciaGeral(historicoEscolarAtual.getFrequenciaGeral());
        historicoEscolar.setSituacaoFinal(historicoEscolarAtual.getSituacaoFinal());
        historicoEscolar.setDataEmissao(historicoEscolarAtual.getDataEmissao());
        historicoEscolar.setInstituicao(historicoEscolarAtual.getInstituicao());
        historicoEscolar.setPeriodo(historicoEscolarAtual.getPeriodo());
        return historicoEscolar;
    }

    @Override
    public HistoricoEscolar delete(String id) {
        return null;
    }
}
