package com.educa.mscatalogo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

    @GetMapping("/buscar")
    public String buscar(@RequestParam String query) {
        return "Resultados de busqueda para: " + query;
    }

    @PostMapping("/inventario")
    public String agregarLibro(@RequestBody String libro) {
        return "Libro agregado al inventario";
    }

    @GetMapping("/{id}/disponibilidad")
    public String consultarDisponibilidad(@PathVariable Long id) {
        return "Disponibilidad del libro " + id;
    }
}
