package com.pinoen.proyectointegrador.service;

import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private IOdontologoService iOdontologoService;

    @Test
    @Order(1)
    void createOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Perez", "Pablo", "A1111");
        iOdontologoService.createOdontologo(odontologoDTO);

        assertTrue(odontologoDTO.getNombre() == "Pablo");
    }

    @Test
    @Order(2)
    void findOdontologoById() {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Ravena", "Enzo", "A2222");
        iOdontologoService.createOdontologo(odontologoDTO);
        OdontologoDTO odontologoRavena = iOdontologoService.findOdontologoById(2L);

        assertEquals(2, odontologoRavena.getId());
    }

    @Test
    @Order(3)
    void updateOdontologo() {
        OdontologoDTO odontologoDTO = new OdontologoDTO(1L,"Perez", "Juan", "A1111");
        iOdontologoService.updateOdontologo(odontologoDTO);

        assertEquals("Juan", odontologoDTO.getNombre());
    }

    @Test
    @Order(4)
    void deleteOdontologoById() {
        iOdontologoService.deleteOdontologoById(2L);
        Set<OdontologoDTO> odontologosDTO = iOdontologoService.getAll();

        assertEquals(1, odontologosDTO.size());
    }

    @Test
    @Order(5)
    void getAll() {
        Set<OdontologoDTO> odontologosDTO = iOdontologoService.getAll();
        assertEquals(1, odontologosDTO.size());
    }
}