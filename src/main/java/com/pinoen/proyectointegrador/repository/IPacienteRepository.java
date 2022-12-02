package com.pinoen.proyectointegrador.repository;

import com.pinoen.proyectointegrador.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findPacienteByEmail(String email);
}
