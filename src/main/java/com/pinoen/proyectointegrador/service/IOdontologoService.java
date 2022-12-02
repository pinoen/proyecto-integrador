package com.pinoen.proyectointegrador.service;

import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import com.pinoen.proyectointegrador.dto.PacienteDTO;

import java.util.Set;

public interface IOdontologoService {
    void createOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO findOdontologoById(Long id);
    void updateOdontologo(OdontologoDTO odontologoDTO);
    void deleteOdontologoById(Long id);
    Set<OdontologoDTO> getAll();
}
