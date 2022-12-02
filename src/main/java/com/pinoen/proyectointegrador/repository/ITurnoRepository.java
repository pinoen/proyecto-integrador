package com.pinoen.proyectointegrador.repository;

import com.pinoen.proyectointegrador.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
