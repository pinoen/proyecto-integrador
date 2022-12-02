package com.pinoen.proyectointegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.proyectointegrador.dto.PacienteDTO;
import com.pinoen.proyectointegrador.entity.Paciente;
import com.pinoen.proyectointegrador.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO findPacienteById(Long id) {
        Optional<Paciente> paciente = iPacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public void updatePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public void deletePacienteById(Long id) {
        iPacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> getAll() {
        List<Paciente> pacientes = iPacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public PacienteDTO findPacienteByEmail(String email) {
        Optional<Paciente> paciente = iPacienteRepository.findPacienteByEmail(email);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }
}
