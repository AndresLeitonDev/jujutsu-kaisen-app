package com.jujutsu.controller;

import com.jujutsu.model.Personaje;
import com.jujutsu.service.PersonajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personajes")
@CrossOrigin(origins = "*")
@Tag(name = "Personajes", description = "API de personajes de Jujutsu Kaisen")
public class PersonajeController {

    @Autowired
    private PersonajeService service;

    @GetMapping
    @Operation(summary = "Obtener todos los personajes")
    public ResponseEntity<List<Personaje>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{nombre}")
    @Operation(summary = "Obtener personaje por nombre")
    public ResponseEntity<?> obtenerPorNombre(@PathVariable String nombre) {
        return service.obtenerPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo personaje")
    public ResponseEntity<Personaje> crear(@RequestBody Personaje personaje) {
        return ResponseEntity.ok(service.crear(personaje));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un personaje")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}