package com.condominio.apicondominio.validation;

import com.condominio.apicondominio.Dto.VisitanteRequestDto;
import com.condominio.apicondominio.exception.CpfInvalidoException;
import com.condominio.apicondominio.exception.NomeInvalidoException;

import java.util.Optional;
import java.util.function.Predicate;

public class VisitanteValidation {

    private VisitanteValidation(){}

    public static void validarCriacaoDoVisitante(VisitanteRequestDto dto){
        Optional.ofNullable(dto.getCpf()).filter(Predicate.not(String::isEmpty)).orElseThrow(CpfInvalidoException:: new);
        Optional.ofNullable(dto.getNome()).filter(Predicate.not(String::isEmpty)).orElseThrow(NomeInvalidoException:: new);
    }
}
