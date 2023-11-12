package com.tutorial.crud.service;

import com.tutorial.crud.entity.Lista;
import com.tutorial.crud.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListaService {

    @Autowired
    ListaRepository listaRepository;

    public List<Lista> list(){
        return listaRepository.findAll();
    }

    public Optional<Lista> getOne(int id){
        return listaRepository.findById(id);
    }

    public Optional<Lista> getByNombre(String nombre){
        return listaRepository.findByNombre(nombre);
    }

    public void  save(Lista lista){
        listaRepository.save(lista);
    }

    public void delete(int id){
        listaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return listaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return listaRepository.existsByNombre(nombre);
    }
}
