package com.pinoen.proyectointegrador.repository;

import com.pinoen.proyectointegrador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
