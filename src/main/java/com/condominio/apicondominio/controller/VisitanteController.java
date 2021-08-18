package com.condominio.apicondominio.controller;
import com.condominio.apicondominio.Dto.VisitanteRequestDto;
import com.condominio.apicondominio.entity.Visitante;
import com.condominio.apicondominio.service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visitantes")
@RequiredArgsConstructor
public class VisitanteController {


    private final VisitanteService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Visitante criar(@RequestBody VisitanteRequestDto dto){
        return service.criar(dto);
    }
}
