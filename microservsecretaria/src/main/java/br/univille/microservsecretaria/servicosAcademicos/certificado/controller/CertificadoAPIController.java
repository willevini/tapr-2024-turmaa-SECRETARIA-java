package br.univille.microservsecretaria.servicosAcademicos.certificado.controller;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.aluno.repository.AlunoRepository;
import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.CursoExtensao;
import br.univille.microservsecretaria.servicosAcademicos.certificado.repository.CursoExtensaoRepository;
import br.univille.microservsecretaria.servicosAcademicos.certificado.dto.CertificadoDto;
import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.Certificado;
import br.univille.microservsecretaria.servicosAcademicos.certificado.mapper.CertificadoMapper;
import br.univille.microservsecretaria.servicosAcademicos.certificado.service.CertificadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/certificado")
public class CertificadoAPIController {

    @Autowired
    private CertificadoService certificadoService;

    @Autowired
    private CursoExtensaoRepository cursoExtensaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<CertificadoDto>> get() {
        List<Certificado> listaCertificados = certificadoService.getAll();
        List<CertificadoDto> listaCertificadosDto = listaCertificados.stream()
                .map(CertificadoMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(listaCertificadosDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody CertificadoDto certificadoDTO) {
        if (certificadoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CursoExtensao cursoExtensao = cursoExtensaoRepository.findByCodigo(certificadoDTO.getCodigoCursoExtensao());
        if (cursoExtensao == null) return new ResponseEntity<>("Curso de extensão não encontrado", HttpStatus.BAD_REQUEST);

        Aluno aluno = alunoRepository.findByMatricula(certificadoDTO.getMatriculaAluno());
        if (aluno == null) return new ResponseEntity<>("Aluno não encontrado", HttpStatus.BAD_REQUEST);

        Certificado novoCertificado = certificadoService.save(CertificadoMapper.toEntity(certificadoDTO, cursoExtensao, aluno));
        return new ResponseEntity<>(CertificadoMapper.toDTO(novoCertificado), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @Valid @RequestBody CertificadoDto certificadoDTO) {
        if (certificadoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CursoExtensao cursoExtensao = cursoExtensaoRepository.findByCodigo(certificadoDTO.getCodigoCursoExtensao());
        if (cursoExtensao == null) return new ResponseEntity<>("Curso de extensão não encontrado", HttpStatus.BAD_REQUEST);

        Aluno aluno = alunoRepository.findByMatricula(certificadoDTO.getMatriculaAluno());
        if (aluno == null) return new ResponseEntity<>("Aluno não encontrado", HttpStatus.BAD_REQUEST);

        Certificado certificadoAtualizado = certificadoService.update(id, CertificadoMapper.toEntity(certificadoDTO, cursoExtensao, aluno));
        return new ResponseEntity<>(CertificadoMapper.toDTO(certificadoAtualizado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CertificadoDto> delete(@PathVariable("id") String id) {
        Certificado certificadoDeletado = certificadoService.delete(id);
        return new ResponseEntity<>(CertificadoMapper.toDTO(certificadoDeletado), HttpStatus.OK);
    }
}
