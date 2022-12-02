package com.pinoen.proyectointegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.proyectointegrador.dto.TurnoDTO;
import com.pinoen.proyectointegrador.entity.Turno;
import com.pinoen.proyectointegrador.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);
    }

    @Override
    public TurnoDTO findTurnoById(Long id) {
        Optional<Turno> turno = iTurnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public void updateTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);
    }

    @Override
    public void deleteTurnoById(Long id) {
        iTurnoRepository.deleteById(id);

    }

    @Override
    public Set<TurnoDTO> getAll() {
        List<Turno> turnos = iTurnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }
}
