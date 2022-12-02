package com.pinoen.proyectointegrador.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import com.pinoen.proyectointegrador.dto.PacienteDTO;
import com.pinoen.proyectointegrador.dto.TurnoDTO;
import com.pinoen.proyectointegrador.entity.Domicilio;
import com.pinoen.proyectointegrador.entity.Odontologo;
import com.pinoen.proyectointegrador.entity.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private ITurnoService iTurnoService;
    @Autowired
    private IPacienteService iPacienteService;
    @Autowired
    private IOdontologoService iOdontologoService;

    @Autowired
    ObjectMapper mapper;

    @Test
    @Order(1)
    void createTurno() {
        PacienteDTO pacienteDTO = new PacienteDTO("Fernandez", "Tomas", "30145632", LocalDate.of(2022,12,01),"tfernandez@gmail.com", new Domicilio("San Martin", 741, "Mendoza", "Mendoza"));
        OdontologoDTO odontologoDTO = new OdontologoDTO("Perez", "Pablo", "A1111");

        TurnoDTO turnoDTO = new TurnoDTO();
        iTurnoService.createTurno(turnoDTO);

        assertEquals(1L, turnoDTO.getId());
    }

    @Test
    @Order(2)
    void findTurnoById() {
        TurnoDTO turnoDTO = iTurnoService.findTurnoById(1L);

        assertNotNull(turnoDTO.getId());
    }

    @Test
    @Order(3)
    void updateTurno() {
        TurnoDTO turnoDTO = new TurnoDTO();
        iTurnoService.createTurno(turnoDTO);

        assertEquals(LocalDate.of(2022,12,21), turnoDTO.getFecha());
    }

    @Test
    @Order(4)
    void deleteTurnoById() {
        iTurnoService.deleteTurnoById(1L);
        Set<TurnoDTO> turnosDTO = iTurnoService.getAll();

        assertEquals(0, turnosDTO.size());
    }

    @Test
    @Order(5)
    void getAll() {
        PacienteDTO pacienteDTO = new PacienteDTO("Fernandez", "Tomas", "30145632", LocalDate.of(2022,12,01),"tfernandez@gmail.com", new Domicilio("San Martin", 741, "Mendoza", "Mendoza"));
        iPacienteService.createPaciente(pacienteDTO);

        OdontologoDTO odontologoDTO = new OdontologoDTO("Perez", "Pablo", "A1111");
        iOdontologoService.createOdontologo(odontologoDTO);

        TurnoDTO turnoDTO = new TurnoDTO();
        iTurnoService.createTurno(turnoDTO);

        Set<TurnoDTO> turnosDTO = new HashSet<>();
        turnosDTO.add(turnoDTO);

        assertEquals(1, turnosDTO.size());
    }
}