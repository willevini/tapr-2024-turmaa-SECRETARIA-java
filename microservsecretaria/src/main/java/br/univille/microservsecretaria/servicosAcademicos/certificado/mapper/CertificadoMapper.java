package br.univille.microservsecretaria.servicosAcademicos.certificado.mapper;

import br.univille.microservsecretaria.aluno.entity.Aluno;
import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.CursoExtensao;
import br.univille.microservsecretaria.servicosAcademicos.certificado.dto.CertificadoDto;
import br.univille.microservsecretaria.servicosAcademicos.certificado.entity.Certificado;

public class CertificadoMapper {

    public static CertificadoDto toDTO(Certificado certificado) {
        CertificadoDto dto = new CertificadoDto();
        dto.setDataEmissao(certificado.getDataEmissao());
        dto.setTitulo(certificado.getTitulo());
        dto.setDescricao(certificado.getDescricao());
        dto.setCargaHoraria(certificado.getCargaHoraria());

        return dto;
    };

    public static Certificado toEntity(CertificadoDto dto, CursoExtensao cursoExtensao, Aluno aluno) {
        Certificado certificado = new Certificado();
        certificado.setAluno(aluno);
        certificado.setCursoExtensao(cursoExtensao);
        certificado.setDataEmissao(dto.getDataEmissao());
        certificado.setTitulo(dto.getTitulo());
        certificado.setDescricao(dto.getDescricao());
        certificado.setCargaHoraria(dto.getCargaHoraria());

        return certificado;
    };
}
