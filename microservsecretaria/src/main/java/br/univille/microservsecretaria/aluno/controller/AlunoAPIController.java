package br.univille.microservsecretaria.aluno.controller;

import java.util.List;

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

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.aluno.service.AlunoService;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoAPIController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> get() {
        List<Aluno> listaAlunos = alunoService.getAll();

        return new ResponseEntity<>(listaAlunos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aluno> post(@RequestBody Aluno aluno) {
        if (aluno == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Aluno novoAluno = alunoService.save(aluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") String id, @RequestBody Aluno aluno) {
        if (aluno == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Aluno alunoAtualizado = alunoService.update(id, aluno);
        return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable("id") String id) {
        Aluno alunoDeletado = alunoService.delete(id);
        return new ResponseEntity<>(alunoDeletado, HttpStatus.OK);
    }
}
