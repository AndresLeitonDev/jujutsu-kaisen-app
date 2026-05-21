package com.jujutsu.repository;

import com.jujutsu.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    Optional<Personaje> findByNombreIgnoreCase(String nombre);
}