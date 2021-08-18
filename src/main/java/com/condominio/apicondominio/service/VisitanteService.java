package com.condominio.apicondominio.service;
import com.condominio.apicondominio.entity.Visitante;
import com.condominio.apicondominio.repository.VisitanteRepository;
import com.condominio.apicondominio.Dto.VisitanteRequestDto;
import com.condominio.apicondominio.validation.VisitanteValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository repository;

    public Visitante criar(VisitanteRequestDto dto){
        VisitanteValidation.validarCriacaoDoVisitante(dto);

        var id = UUID.randomUUID().toString();
        var visitante = new Visitante(id, dto.getCpf(), dto.getNome());
         return repository.save(visitante);
    }
}
