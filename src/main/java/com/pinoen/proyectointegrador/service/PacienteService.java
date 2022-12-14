package com.pinoen.proyectointegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.proyectointegrador.dto.PacienteDTO;
import com.pinoen.proyectointegrador.entity.Paciente;
import com.pinoen.proyectointegrador.repository.IPacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createPaciente(PacienteDTO pacienteDTO) {
        logger.info("Operacion iniciada: registro de nuevo paciente dni: " + pacienteDTO.getDni());
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO findPacienteById(Long id) {
        logger.info("Operacion iniciada: busqueda de paciente id = " + id);
        Optional<Paciente> paciente = iPacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public void updatePaciente(PacienteDTO pacienteDTO) {
        logger.info("Operacion iniciada: actualizacion de datos de paciente dni: " + pacienteDTO.getDni());
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public void deletePacienteById(Long id) {
        logger.warn("Operacion iniciada: eliminacion de paciente id = " + id);
        iPacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> getAll() {
        logger.info("Operacion iniciada: listado de pacientes.");
        List<Paciente> pacientes = iPacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public PacienteDTO findPacienteByEmail(String email) {
        logger.info("Operacion iniciada: busqueda de paciente por email " + email);
        Optional<Paciente> paciente = iPacienteRepository.findPacienteByEmail(email);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }
}
