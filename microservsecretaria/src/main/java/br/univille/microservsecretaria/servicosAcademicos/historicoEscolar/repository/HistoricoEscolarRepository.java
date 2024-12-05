package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.repository;

import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.entity.HistoricoEscolar;
import com.azure.spring.data.cosmos.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoEscolarRepository extends CrudRepository<HistoricoEscolar, String> {
    @Query("SELECT VALUE COUNT(1) FROM c WHERE c.curso.codigo = @cursoCodigo AND c.dataCriacao >= @startDate AND c.dataCriacao < @endDate")
    long countByCursoAndDataCriacao(@Param("cursoCodigo") String cursoCodigo, @Param("startDate") String startDate, @Param("endDate") String endDate);

}
