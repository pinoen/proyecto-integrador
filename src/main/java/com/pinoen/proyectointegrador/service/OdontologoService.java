package com.pinoen.proyectointegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import com.pinoen.proyectointegrador.entity.Odontologo;
import com.pinoen.proyectointegrador.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO findOdontologoById(Long id) {
        Optional<Odontologo> odontologo = iOdontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public void updateOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public void deleteOdontologoById(Long id) {
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> getAll() {
        List<Odontologo> odontologos = iOdontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for(Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}
