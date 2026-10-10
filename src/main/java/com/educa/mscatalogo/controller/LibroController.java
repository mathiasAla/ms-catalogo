package com.educa.mscatalogo.controller;

import com.educa.mscatalogo.model.Libro;
import com.educa.mscatalogo.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listar() {
        return libroService.listar();
    }

    @GetMapping("/{id}")
    public Libro obtener(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }

    // RF1: busqueda por titulo o autor
    @GetMapping("/buscar")
    public List<Libro> buscar(@RequestParam String texto) {
        return libroService.buscar(texto);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Libro> listarPorCategoria(@PathVariable Long categoriaId) {
        return libroService.listarPorCategoria(categoriaId);
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody Libro libro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.crear(libro));
    }

    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @Valid @RequestBody Libro libro) {
        return libroService.actualizar(id, libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}