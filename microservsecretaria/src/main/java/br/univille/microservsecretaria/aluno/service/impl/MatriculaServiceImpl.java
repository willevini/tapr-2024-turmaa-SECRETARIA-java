package br.univille.microservsecretaria.aluno.service.impl;

import br.univille.microservsecretaria.aluno.entity.Curso;
import br.univille.microservsecretaria.aluno.repository.AlunoRepository;
import br.univille.microservsecretaria.aluno.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy");

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public String gerarMatricula(Curso curso) {
        String year = DATE_FORMAT.format(new Date());

        if (curso == null) return null;

        int sequenceNumber = 1;
        int yearInt = Integer.parseInt(year);
        LocalDateTime startDate = LocalDateTime.of(yearInt, 1, 1, 0, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(yearInt, 12, 31, 23, 59, 59, 999999999);

        long totalAlunos = alunoRepository.countByCursoAndDataCriacao(curso.getCodigo(), startDate.toString(), endDate.toString());
        sequenceNumber = Math.toIntExact(totalAlunos + 1);

        return String.format("%s-%s-%04d", year, curso.getCodigo(), sequenceNumber);
    }
}