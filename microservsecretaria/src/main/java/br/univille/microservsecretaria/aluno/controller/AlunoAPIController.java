package br.univille.microservsecretaria.aluno.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.univille.microservsecretaria.comum.entity.Curso;
import br.univille.microservsecretaria.aluno.mapper.AlunoMapper;
import br.univille.microservsecretaria.comum.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservsecretaria.aluno.dto.AlunoDTO;
import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.aluno.service.AlunoService;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoAPIController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> get() {
        List<Aluno> listaAlunos = alunoService.getAll();
        List<AlunoDTO> listaAlunosDTO = listaAlunos.stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(listaAlunosDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody AlunoDTO alunoDTO) {
        if (alunoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Curso curso = cursoRepository.findByCodigo(alunoDTO.getCodigoCurso());
        if (curso == null) return new ResponseEntity<>("Curso não encontrado", HttpStatus.BAD_REQUEST);


        Aluno novoAluno = alunoService.save(AlunoMapper.toEntity(alunoDTO, curso));
        return new ResponseEntity<>(AlunoMapper.toDTO(novoAluno), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody AlunoDTO alunoDTO) {
        if (alunoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Curso curso = cursoRepository.findByCodigo(alunoDTO.getCodigoCurso());
        if (curso == null) return new ResponseEntity<>("Curso não encontrado", HttpStatus.BAD_REQUEST);

        Aluno alunoAtualizado = alunoService.update(id, AlunoMapper.toEntity(alunoDTO, curso));
        return new ResponseEntity<>(AlunoMapper.toDTO(alunoAtualizado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoDTO> delete(@PathVariable("id") String id) {
        Aluno alunoDeletado = alunoService.delete(id);
        return new ResponseEntity<>(AlunoMapper.toDTO(alunoDeletado), HttpStatus.OK);
    }
}