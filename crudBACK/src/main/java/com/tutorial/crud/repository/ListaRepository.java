package com.tutorial.crud.repository;

import com.tutorial.crud.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    Optional<Lista> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}