package br.univille.microservsecretaria.aluno.utils;

public class CpfUtils {

    private static final Integer TAMANHO_CPF = 11;

    public Boolean validadorCpf(String cpf) {
        // Remove todos os caracteres que não sejam dígitos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != TAMANHO_CPF) return false;

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) return false;

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int firstCheckDigit = TAMANHO_CPF - (sum % TAMANHO_CPF);
        if (firstCheckDigit >= 10) firstCheckDigit = 0;

        // Verifica o primeiro dígito verificador
        if (firstCheckDigit != Character.getNumericValue(cpf.charAt(9))) return false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (TAMANHO_CPF - i);
        }
        int secondCheckDigit = TAMANHO_CPF - (sum % TAMANHO_CPF);
        if (secondCheckDigit >= 10) secondCheckDigit = 0;

        // Verifica o segundo dígito verificador
        if (secondCheckDigit != Character.getNumericValue(cpf.charAt(10))) return false;

        return true;
    }
}
