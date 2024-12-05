package br.univille.microservsecretaria.servicosAcademicos.diploma.service.impl;

import br.univille.microservsecretaria.servicosAcademicos.diploma.entity.Diploma;
import br.univille.microservsecretaria.servicosAcademicos.diploma.repository.DiplomaRepository;
import br.univille.microservsecretaria.servicosAcademicos.diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiplomaServiceImpl implements DiplomaService {

    @Autowired
    private DiplomaRepository repository;

    @Override
    public List<Diploma> getAll() {
        Iterable<Diploma> alunos = repository.findAll();
        ArrayList<Diploma> listaDiplomas = new ArrayList<>();
        alunos.forEach(listaDiplomas::add);
        return listaDiplomas;
    }

    @Override
    public Diploma save(Diploma diploma) {
        return repository.save(diploma);
    }

    @Override
    public Diploma update(String id, Diploma diploma) {
        Optional<Diploma> diplomaDB = repository.findById(id);
        if (!diplomaDB.isPresent()) return null;

        Diploma diplomaAtual = diplomaDB.get();
        diplomaAtual.setInstituicaoEnsino(diploma.getInstituicaoEnsino());
        diplomaAtual.setDataConclusao(diploma.getDataConclusao());
        diplomaAtual.setDataEmissao(diploma.getDataEmissao());
        diplomaAtual.setTipoDiploma(diploma.getTipoDiploma());
        diplomaAtual.setMediaTotalFinal(diploma.getMediaTotalFinal());

        repository.save(diplomaAtual);
        return diplomaAtual;
    }

    @Override
    public Diploma delete(String id) {
        Optional<Diploma> diplomaDB = repository.findById(id);
        if (!diplomaDB.isPresent()) return null;

        repository.delete(diplomaDB.get());
        return diplomaDB.get();
    }
}
