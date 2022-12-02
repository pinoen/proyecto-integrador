package com.pinoen.proyectointegrador.controller;

import com.pinoen.proyectointegrador.dto.OdontologoDTO;
import com.pinoen.proyectointegrador.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService iOdontologoService;

    @PostMapping
    public ResponseEntity<?> createOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.createOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO findOdontologoById(@PathVariable Long id){
        return iOdontologoService.findOdontologoById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.updateOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOdontologo(@PathVariable Long id){
        iOdontologoService.deleteOdontologoById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDTO> getAll(){
        return iOdontologoService.getAll();
    }
}
