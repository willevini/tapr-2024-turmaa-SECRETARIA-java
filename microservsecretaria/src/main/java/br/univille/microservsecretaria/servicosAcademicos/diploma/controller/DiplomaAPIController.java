package br.univille.microservsecretaria.servicosAcademicos.diploma.controller;

import br.univille.microservsecretaria.aluno.entity.Aluno;

import br.univille.microservsecretaria.aluno.service.AlunoService;
import br.univille.microservsecretaria.comum.entity.Curso;

import br.univille.microservsecretaria.comum.repository.CursoRepository;
import br.univille.microservsecretaria.servicosAcademicos.diploma.dto.DiplomaSaveDTO;
import br.univille.microservsecretaria.servicosAcademicos.diploma.dto.DiplomaUpdateDTO;
import br.univille.microservsecretaria.servicosAcademicos.diploma.entity.Diploma;
import br.univille.microservsecretaria.servicosAcademicos.diploma.mapper.DiplomaMapper;
import br.univille.microservsecretaria.servicosAcademicos.diploma.service.DiplomaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/diplomas")
public class DiplomaAPIController {

    @Autowired
    private DiplomaService diplomaService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<DiplomaSaveDTO>> get() {
        List<Diploma> listaDiplomas = diplomaService.getAll();
        List<DiplomaSaveDTO> listaDiplomasDTO = listaDiplomas.stream()
                .map(DiplomaMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(listaDiplomasDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody DiplomaSaveDTO diplomaDTO) {
        if (diplomaDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Curso curso = cursoRepository.findByCodigo(diplomaDTO.getCodigoCurso());
        if (curso == null) return new ResponseEntity<>("Curso não encontrado", HttpStatus.BAD_REQUEST);

        Aluno aluno = alunoService.getAlunoById(diplomaDTO.getAlunoId());
        if (aluno == null) return new ResponseEntity<>("Aluno não encontrado", HttpStatus.BAD_REQUEST);

        Diploma novoDiploma = diplomaService.save(DiplomaMapper.toEntitySave(diplomaDTO, aluno, curso));
        return new ResponseEntity<>(DiplomaMapper.toDTO(novoDiploma), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody DiplomaUpdateDTO diplomaDTO) {
        if (diplomaDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Diploma diplomaAtualizado = diplomaService.update(id, DiplomaMapper.toEntityUpdate(diplomaDTO));
        return new ResponseEntity<>(DiplomaMapper.toDTO(diplomaAtualizado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DiplomaSaveDTO> delete(@PathVariable("id") String id) {
        Diploma diplomaDeletado = diplomaService.delete(id);
        return new ResponseEntity<>(DiplomaMapper.toDTO(diplomaDeletado), HttpStatus.OK);
    }
}