package com.condominio.apicondominio.repository;


import com.condominio.apicondominio.entity.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, String > {
}
