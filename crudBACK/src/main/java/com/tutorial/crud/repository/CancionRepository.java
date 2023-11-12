package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Cancion;
import com.tutorial.crud.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    Optional<Cancion> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);

    Optional<Cancion> findByLista(Lista lista);
}