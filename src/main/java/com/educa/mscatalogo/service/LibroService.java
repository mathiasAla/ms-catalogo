package com.educa.mscatalogo.service;

import com.educa.mscatalogo.exception.RecursoNoEncontradoException;
import com.educa.mscatalogo.model.Categoria;
import com.educa.mscatalogo.model.Libro;
import com.educa.mscatalogo.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final CategoriaService categoriaService;

    public LibroService(LibroRepository libroRepository, CategoriaService categoriaService) {
        this.libroRepository = libroRepository;
        this.categoriaService = categoriaService;
    }

    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado con id " + id));
    }

    public List<Libro> buscar(String texto) {
        return libroRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(texto, texto);
    }

    public List<Libro> listarPorCategoria(Long categoriaId) {
        categoriaService.buscarPorId(categoriaId);
        return libroRepository.findByCategoriaId(categoriaId);
    }

    @Transactional
    public Libro crear(Libro libro) {
        libro.setId(null);
        libro.setCategoria(resolverCategoria(libro));
        return libroRepository.save(libro);
    }

    @Transactional
    public Libro actualizar(Long id, Libro datos) {
        Libro existente = buscarPorId(id);
        existente.setTitulo(datos.getTitulo());
        existente.setAutor(datos.getAutor());
        existente.setStock(datos.getStock());
        existente.setCategoria(resolverCategoria(datos));
        return libroRepository.save(existente);
    }

    @Transactional
    public void eliminar(Long id) {
        libroRepository.delete(buscarPorId(id));
    }

    
    private Categoria resolverCategoria(Libro libro) {
        if (libro.getCategoria() == null || libro.getCategoria().getId() == null) {
            throw new IllegalArgumentException("Debe indicar la categoria del libro (categoria.id)");
        }
        return categoriaService.buscarPorId(libro.getCategoria().getId());
    }
}