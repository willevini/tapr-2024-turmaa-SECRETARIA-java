package br.univille.microservsecretaria.servicosAcademicos.diploma.mapper;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.comum.entity.Curso;
import br.univille.microservsecretaria.servicosAcademicos.diploma.dto.DiplomaSaveDTO;
import br.univille.microservsecretaria.servicosAcademicos.diploma.dto.DiplomaUpdateDTO;
import br.univille.microservsecretaria.servicosAcademicos.diploma.entity.Diploma;

public class DiplomaMapper {

    public static DiplomaSaveDTO toDTO(Diploma diploma) {
        DiplomaSaveDTO dto = new DiplomaSaveDTO();
        dto.setInstituicaoEnsino(diploma.getInstituicaoEnsino());
        dto.setDataConclusao(diploma.getDataConclusao());
        dto.setDataEmissao(diploma.getDataEmissao());
        dto.setTipoDiploma(diploma.getTipoDiploma());
        dto.setMediaTotalFinal(diploma.getMediaTotalFinal());
        return dto;
    }

    public static Diploma toEntitySave(DiplomaSaveDTO dto, Aluno aluno, Curso curso) {
        Diploma diploma = new Diploma();
        diploma.setAluno(aluno);
        diploma.setInstituicaoEnsino(dto.getInstituicaoEnsino());
        diploma.setCurso(curso);
        diploma.setDataConclusao(dto.getDataConclusao());
        diploma.setDataEmissao(dto.getDataEmissao());
        diploma.setTipoDiploma(dto.getTipoDiploma());
        diploma.setMediaTotalFinal(dto.getMediaTotalFinal());
        return diploma;
    }

    public static Diploma toEntityUpdate(DiplomaUpdateDTO dto) {
        Diploma diploma = new Diploma();
        diploma.setInstituicaoEnsino(dto.getInstituicaoEnsino());
        diploma.setDataConclusao(dto.getDataConclusao());
        diploma.setDataEmissao(dto.getDataEmissao());
        diploma.setTipoDiploma(dto.getTipoDiploma());
        diploma.setMediaTotalFinal(dto.getMediaTotalFinal());
        return diploma;
    }
}