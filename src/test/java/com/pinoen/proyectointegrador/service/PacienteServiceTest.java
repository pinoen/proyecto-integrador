package com.pinoen.proyectointegrador.service;

import com.pinoen.proyectointegrador.dto.PacienteDTO;
import com.pinoen.proyectointegrador.entity.Domicilio;
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
class PacienteServiceTest {

    @Autowired
    private IPacienteService iPacienteService;

    @Test
    @Order(1)
    void createPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO("Fernandez",
                "Tomas",
                "30145632",
                LocalDate.of(2022,12,01),
                "tfernandez@gmail.com",
                new Domicilio("San Martin", 741, "Mendoza", "Mendoza"));
        iPacienteService.createPaciente(pacienteDTO);

        assertTrue("Tomas" == pacienteDTO.getNombre());
    }

    @Test
    @Order(2)
    void findPacienteById() {
        PacienteDTO pacienteDTO = iPacienteService.findPacienteById(1L);

        assertNotNull(pacienteDTO.getId());
    }

    @Test
    @Order(3)
    void updatePaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO(1L, "Fernandez", "Tomas", "30145632", LocalDate.of(2022,12,01),"tfernandez@yahoo.com.ar", new Domicilio("San Martin", 741, "Mendoza", "Mendoza"));

        assertEquals("tfernandez@yahoo.com.ar", pacienteDTO.getEmail());
    }

    @Test
    @Order(4)
    void deletePacienteById() {
        iPacienteService.deletePacienteById(1L);
        Set<PacienteDTO> pacientesDTO = iPacienteService.getAll();

        assertEquals(0, pacientesDTO.size());
    }

    @Test
    @Order(5)
    void getAll() {
        PacienteDTO pacienteDTO = new PacienteDTO("Santillan", "Ricardo", "31145639", LocalDate.of(2022,11,03),"rsantillan@yahoo.com.ar", new Domicilio("San Lorenzo", 456, "Mendoza", "Mendoza"));
        PacienteDTO pacienteDTO1 = new PacienteDTO("Romero", "Ariel", "33145635", LocalDate.of(2022,10,04),"aromero@yahoo.com.ar", new Domicilio("San Sebastian", 454, "Mendoza", "Mendoza"));
        iPacienteService.createPaciente(pacienteDTO);
        iPacienteService.createPaciente(pacienteDTO1);
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        pacientesDTO.add(pacienteDTO);
        pacientesDTO.add(pacienteDTO1);


        assertEquals(2, pacientesDTO.size());
    }

    @Test
    @Order(6)
    void findPacienteByEmail() {
        PacienteDTO pacienteDTO = iPacienteService.findPacienteByEmail("aromero@yahoo.com.ar");

        assertEquals("Romero", pacienteDTO.getApellido());
    }
}