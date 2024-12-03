package br.univille.microservsecretaria.aluno.service.impl;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.aluno.entity.Curso;
import br.univille.microservsecretaria.aluno.repository.AlunoRepository;
import br.univille.microservsecretaria.aluno.repository.CursoRepository;
import br.univille.microservsecretaria.aluno.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy");

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public String gerarMatricula(String courseCode) {
        String year = DATE_FORMAT.format(new Date());
        Curso curso = cursoRepository.findByCodigo(courseCode);

        int sequenceNumber = 1;
        if (curso == null) return null;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        Date endDate = calendar.getTime();

        List<Aluno> alunos = alunoRepository.findByCursoAndDataCriacaoBetween(curso, startDate, endDate);
        if (alunos != null && !alunos.isEmpty()) {
            sequenceNumber = alunos.size() + 1;
        }

        return String.format("%s-%s-%04d", year, courseCode, sequenceNumber);
    }
}