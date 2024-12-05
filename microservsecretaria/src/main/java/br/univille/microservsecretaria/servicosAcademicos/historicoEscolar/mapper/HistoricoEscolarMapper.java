package br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.mapper;

import br.univille.microservsecretaria.comum.entity.Curso;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.dto.HistoricoEscolarDTO;
import br.univille.microservsecretaria.servicosAcademicos.historicoEscolar.entity.HistoricoEscolar;

public class HistoricoEscolarMapper {

    public static HistoricoEscolarDTO toDTO(HistoricoEscolar historicoEscolar) {
        HistoricoEscolarDTO dto = new HistoricoEscolarDTO();
        dto.setCurso(historicoEscolar.getCurso());
        dto.setMediaGeral(historicoEscolar.getMediaGeral());
        dto.setFrequenciaGeral(historicoEscolar.getFrequenciaGeral());
        dto.setSituacaoFinal(historicoEscolar.getSituacaoFinal());
        dto.setDataEmissao(historicoEscolar.getDataEmissao());
        dto.setInstituicao(historicoEscolar.getInstituicao());
        dto.setPeriodo(historicoEscolar.getPeriodo());
        return dto;
    }

    public static HistoricoEscolar toEntity(HistoricoEscolarDTO dto, Curso curso) {
        HistoricoEscolar historicoEscolar = new HistoricoEscolar();
        historicoEscolar.setCurso(curso);
        historicoEscolar.setMediaGeral(dto.getMediaGeral());
        historicoEscolar.setFrequenciaGeral(dto.getFrequenciaGeral());
        historicoEscolar.setSituacaoFinal(dto.getSituacaoFinal());
        historicoEscolar.setDataEmissao(dto.getDataEmissao());
        historicoEscolar.setInstituicao(dto.getInstituicao());
        historicoEscolar.setPeriodo(dto.getPeriodo());
        return historicoEscolar;
    }
}
