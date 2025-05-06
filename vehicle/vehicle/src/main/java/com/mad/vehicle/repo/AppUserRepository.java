package com.mad.vehicle.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.vehicle.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}