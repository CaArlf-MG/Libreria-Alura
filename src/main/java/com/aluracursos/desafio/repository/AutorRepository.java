package com.aluracursos.desafio.repository;

import com.aluracursos.desafio.model.Autor;
import com.aluracursos.desafio.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a JOIN FETCH a.libros")
    List<Autor> findAutoresConLibros(); // Consulta para obtener autores con sus libros

    // Método adicional para encontrar autor por nombre
    Optional<Autor> findByNombre(String nombre);
}
