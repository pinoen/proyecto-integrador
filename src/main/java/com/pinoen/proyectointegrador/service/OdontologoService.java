package com.pinoen.proyectointegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import com.pinoen.proyectointegrador.entity.Odontologo;
import com.pinoen.proyectointegrador.repository.IOdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createOdontologo(OdontologoDTO odontologoDTO) {
        logger.info("Operacion iniciada: registro de nuevo odontologo matricula: " + odontologoDTO.getMatricula());
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO findOdontologoById(Long id) {
        logger.info("Operacion iniciada: busqueda de odontologo id = " + id);
        Optional<Odontologo> odontologo = iOdontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public void updateOdontologo(OdontologoDTO odontologoDTO) {
        logger.info("Operacion iniciada: actualizacion de datos de odontologo matricula: " + odontologoDTO.getMatricula());
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public void deleteOdontologoById(Long id) {
        logger.warn("Operacion iniciada: eliminacion de odontologo id = " + id);
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> getAll() {
        logger.info("Operacion iniciada: listado de odontologos.");
        List<Odontologo> odontologos = iOdontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for(Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}
