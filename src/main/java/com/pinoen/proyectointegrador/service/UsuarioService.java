package com.pinoen.proyectointegrador.service;

import com.pinoen.proyectointegrador.entity.Usuario;
import com.pinoen.proyectointegrador.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = iUsuarioRepository.findByEmail((username));
        if(usuario.isPresent()){
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado en base de datos");
        }
    }
}
