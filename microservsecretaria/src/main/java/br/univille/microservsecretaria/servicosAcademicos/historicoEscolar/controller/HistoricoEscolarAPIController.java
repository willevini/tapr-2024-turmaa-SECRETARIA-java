package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.controller;


import br.univille.microservsecretaria.comum.entity.Curso;
import br.univille.microservsecretaria.comum.repository.CursoRepository;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.dto.HistoricoEscolarDTO;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.entity.HistoricoEscolar;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.mapper.HistoricoEscolarMapper;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.service.HistoricoEscolarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/historicoEscolar")
public class HistoricoEscolarAPIController {

    @Autowired
    private HistoricoEscolarService historicoEscolarService;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<HistoricoEscolarDTO>> get() {
        List<HistoricoEscolar> listaHistoricosEscolares = historicoEscolarService.getAll();
        List<HistoricoEscolarDTO> listaHistoricosEscolaresDTO = listaHistoricosEscolares.stream()
                .map(HistoricoEscolarMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(listaHistoricosEscolaresDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody HistoricoEscolarDTO historicoEscolarDTO) {
        if (historicoEscolarDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Curso curso = cursoRepository.findByCodigo(historicoEscolarDTO.getCurso().getId());
        if (curso == null) return new ResponseEntity<>("Curso não encontrado", HttpStatus.BAD_REQUEST);


        HistoricoEscolar novoHistoricoEscolar = historicoEscolarService.save(HistoricoEscolarMapper.toEntity(historicoEscolarDTO, curso));
        return new ResponseEntity<>(HistoricoEscolarMapper.toDTO(novoHistoricoEscolar), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody HistoricoEscolarDTO historicoEscolarDTO) {
        if (historicoEscolarDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Curso curso = cursoRepository.findByCodigo(historicoEscolarDTO.getCurso().getId());
        if (curso == null) return new ResponseEntity<>("Curso não encontrado", HttpStatus.BAD_REQUEST);

        HistoricoEscolar historicoEscolarAtualizado = historicoEscolarService.update(id, HistoricoEscolarMapper.toEntity(historicoEscolarDTO, curso));
        return new ResponseEntity<>(HistoricoEscolarMapper.toDTO(historicoEscolarAtualizado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HistoricoEscolarDTO> delete(@PathVariable("id") String id) {
        HistoricoEscolar historicoEscolarDeletado = historicoEscolarService.delete(id);
        return new ResponseEntity<>(HistoricoEscolarMapper.toDTO(historicoEscolarDeletado), HttpStatus.OK);
    }
}
