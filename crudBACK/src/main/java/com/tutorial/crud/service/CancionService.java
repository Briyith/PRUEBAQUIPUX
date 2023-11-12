package com.tutorial.crud.service;

import com.tutorial.crud.entity.Cancion;
import com.tutorial.crud.entity.Lista;
import com.tutorial.crud.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CancionService {

    @Autowired
    CancionRepository cancionRepository;

    public List<Cancion> list(){
        return cancionRepository.findAll();
    }

    public Optional<Cancion> getOne(int id){
        return cancionRepository.findById(id);
    }

    public Optional<Cancion> getByTitulo(String titulo){
        return cancionRepository.findByTitulo(titulo);
    }

    public Optional<Cancion> getByLista(Lista lista){
        return cancionRepository.findByLista(lista);
    }

    public void  save(Cancion cancion){
        cancionRepository.save(cancion);
    }

    public void delete(int id){
        cancionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return cancionRepository.existsById(id);
    }

    public boolean existsByTitulo(String titulo){
        return cancionRepository.existsByTitulo(titulo);
    }
}
