package br.univille.microservsecretaria.aluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.aluno.service.AlunoService;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoAPIController {
    
    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<Aluno>> get(){
        List<Aluno> listaAlunos = service.getAll();

        return new ResponseEntity<List<Aluno>>(listaAlunos, HttpStatus.OK);
    }
}
