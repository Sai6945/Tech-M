package com.mad.vehicle.security;



import com.mad.vehicle.entity.Role;
import com.mad.vehicle.entity.AppUser;
import com.mad.vehicle.repo.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserInitializer {

    @Bean
    public CommandLineRunner createUsers(AppUserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {
                repo.save(new AppUser(null, "admin", encoder.encode("admin123"), Role.ADMIN));
            }
            if (repo.findByUsername("service").isEmpty()) {
                repo.save(new AppUser(null, "service", encoder.encode("service123"), Role.SERVICE_PROVIDER));
            }
        };
    }
}

