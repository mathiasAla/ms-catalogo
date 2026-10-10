package com.educa.mscatalogo.repository;

import com.educa.mscatalogo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // RF1: busqueda por titulo o autor
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);

    List<Libro> findByCategoriaId(Long categoriaId);
}