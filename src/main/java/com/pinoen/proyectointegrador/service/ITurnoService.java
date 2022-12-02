package com.pinoen.proyectointegrador.service;

import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import com.pinoen.proyectointegrador.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void createTurno(TurnoDTO turnoDTO);
    TurnoDTO findTurnoById(Long id);
    void updateTurno(TurnoDTO turnoDTO);
    void deleteTurnoById(Long id);
    Set<TurnoDTO> getAll();
}
