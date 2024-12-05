package br.univille.microservsecretaria.servicosAcademicos.certificado.service.impl;

import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.Certificado;
import br.univille.microservsecretaria.servicosAcademicos.certificado.repository.CertificadoRepository;
import br.univille.microservsecretaria.servicosAcademicos.certificado.service.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CertificadoServiceImpl implements CertificadoService {

    @Autowired
    private CertificadoRepository repository;

    @Override
    public List<Certificado> getAll() {
        Iterable<Certificado> certificados = repository.findAll();
        ArrayList<Certificado> listaCertificados = new ArrayList<>();
        certificados.forEach(listaCertificados::add);
        return listaCertificados;
    }

    @Override
    public Certificado save(Certificado certificado) {

        return repository.save(certificado);
    }

    @Override
    public Certificado update(String id, Certificado certificado) {
        Optional<Certificado> certificadoDB = repository.findById(id);
        if (!certificadoDB.isPresent()) return null;

        Certificado certificadoAtual = certificadoDB.get();

        certificadoAtual.setAluno(certificado.getAluno());
        certificadoAtual.setCursoExtensao(certificado.getCursoExtensao());
        certificadoAtual.setDataEmissao(certificado.getDataEmissao());
        certificadoAtual.setTitulo(certificado.getTitulo());
        certificadoAtual.setDescricao(certificado.getDescricao());
        certificadoAtual.setCargaHoraria(certificado.getCargaHoraria());

        repository.save(certificadoAtual);
        return certificadoAtual;
    }

    @Override
    public Certificado delete(String id) {
        Optional<Certificado> certificadoDB = repository.findById(id);
        if (!certificadoDB.isPresent()) return null;

        repository.delete(certificadoDB.get());
        return certificadoDB.get();
    }
}
