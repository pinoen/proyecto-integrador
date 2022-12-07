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
        BCryptPasswordEncoder encoderUser = new BCryptPasswordEncoder();
        String passwordUser = encoderUser.encode("pinoen");
        Usuario user = new Usuario("Emilio", "pinoen", "pinoen@yahoo.com.ar", passwordUser, UsuarioRole.ROLE_USER);
        iUsuarioRepository.save(user);

        BCryptPasswordEncoder encoderAdmin = new BCryptPasswordEncoder();
        String passwordAdmin = encoderAdmin.encode("pinoem");
        Usuario admin = new Usuario("Nicolas", "pinoem", "pinoem@yahoo.com.ar", passwordAdmin, UsuarioRole.ROLE_ADMIN);
        iUsuarioRepository.save(admin);
    }
}
