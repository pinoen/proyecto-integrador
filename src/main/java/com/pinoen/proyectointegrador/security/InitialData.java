package com.pinoen.proyectointegrador.security;

import com.pinoen.proyectointegrador.entity.Usuario;
import com.pinoen.proyectointegrador.entity.UsuarioRole;
import com.pinoen.proyectointegrador.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements ApplicationRunner {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public InitialData(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("pinoen");
        Usuario usuario = new Usuario("Emilio", "pinoen", "pinoen@yahoo.com.ar", password, UsuarioRole.ROLE_USER);
        iUsuarioRepository.save(usuario);
    }
}
