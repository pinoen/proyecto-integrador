package com.pinoen.proyectointegrador.service;

import com.pinoen.proyectointegrador.dto.PacienteDTO;
import com.pinoen.proyectointegrador.entity.Paciente;

import java.util.Set;

public interface IPacienteService {
    void createPaciente(PacienteDTO pacienteDTO);
    PacienteDTO findPacienteById(Long id);
    void updatePaciente(PacienteDTO pacienteDTO);
    void deletePacienteById(Long id);
    Set<PacienteDTO> getAll();
    PacienteDTO findPacienteByEmail(String email);
}
