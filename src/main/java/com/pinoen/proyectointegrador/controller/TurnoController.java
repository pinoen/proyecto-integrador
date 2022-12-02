package com.pinoen.proyectointegrador.controller;

import com.pinoen.proyectointegrador.dto.TurnoDTO;
import com.pinoen.proyectointegrador.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService iTurnoService;

    @PostMapping
    public ResponseEntity<?> createTurno(@RequestBody TurnoDTO turnoDTO){
        iTurnoService.createTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO findTurnoById(@PathVariable Long id){
        return iTurnoService.findTurnoById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateTurno(@RequestBody TurnoDTO turnoDTO){
        iTurnoService.updateTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable Long id){
        iTurnoService.deleteTurnoById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDTO> getAll(){
        return iTurnoService.getAll();
    }
}