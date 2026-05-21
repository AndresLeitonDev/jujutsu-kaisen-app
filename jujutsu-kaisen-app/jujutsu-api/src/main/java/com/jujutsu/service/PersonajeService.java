package com.jujutsu.service;

import com.jujutsu.model.Personaje;
import com.jujutsu.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository repository;

    public List<Personaje> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Personaje> obtenerPorNombre(String nombre) {
        return repository.findByNombreIgnoreCase(nombre);
    }

    public Personaje crear(Personaje personaje) {
        return repository.save(personaje);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}