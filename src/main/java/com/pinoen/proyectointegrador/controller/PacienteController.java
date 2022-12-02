package com.pinoen.proyectointegrador.controller;

import com.pinoen.proyectointegrador.dto.PacienteDTO;
import com.pinoen.proyectointegrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService iPacienteService;

    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO findPacienteById(@PathVariable Long id){
        return iPacienteService.findPacienteById(id);
    }

    @PutMapping
    public ResponseEntity<?> updatePaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.updatePaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id){
        iPacienteService.deletePacienteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDTO> getAll(){
        return iPacienteService.getAll();
    }
}
