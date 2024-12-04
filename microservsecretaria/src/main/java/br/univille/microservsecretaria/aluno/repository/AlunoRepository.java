package br.univille.microservsecretaria.aluno.repository;

import com.azure.spring.data.cosmos.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.microservsecretaria.aluno.entity.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, String> {

    @Query("SELECT VALUE COUNT(1) FROM c WHERE c.curso.codigo = @cursoCodigo AND c.dataCriacao >= @startDate AND c.dataCriacao < @endDate")
    long countByCursoAndDataCriacao(@Param("cursoCodigo") String cursoCodigo, @Param("startDate") String startDate, @Param("endDate") String endDate);
}