package com.personapi.personapi.Config;




import com.personapi.personapi.Models.User;
import com.personapi.personapi.Service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void run(String... args) throws Exception {
        //userDetailsService.createUser("admin", "admin123", "ADMIN");
        // Verifica si ya existe el usuario admin
        if (userDetailsService.loadUserByUsername("admin") == null) {
            // Crear usuario admin con contraseña encriptada y rol ADMIN
            userDetailsService.createUser("admin", "admin123", "ADMIN");
            System.out.println("Usuario admin creado con contraseña: admin123");
        }
    }
}

