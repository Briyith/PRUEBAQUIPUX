package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ListaDto;
import com.tutorial.crud.entity.Lista;
import com.tutorial.crud.service.ListaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lista")
@CrossOrigin(origins = "http://localhost:4200")
public class ListaController {

    @Autowired
    ListaService listaService;

    @GetMapping("/lists")
    public ResponseEntity<List<Lista>> list(){
        List<Lista> list = listaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/lists/{id}")
    public ResponseEntity<Lista> getById(@PathVariable("id") int id){
        if(!listaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Lista lista = listaService.getOne(id).get();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/lists")
    public ResponseEntity<?> create(@RequestBody ListaDto listaDto){
        try {
            if(StringUtils.isBlank(listaDto.getNombre()))
                return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            if(listaService.existsByNombre(listaDto.getNombre()))
                return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            Lista lista = new Lista(listaDto.getNombre(), listaDto.getDescripcion());
            listaService.save(lista);

            // Construir la URI para la lista creada
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(lista.getId_lista())
                    .toUri();

            // Construir el objeto de respuesta que incluye la URI y el contenido de la lista
            ListaDto listaCreada = new ListaDto(lista.getNombre(), lista.getDescripcion());


            // Devolver la respuesta con la URI y el contenido de la lista
            return ResponseEntity.created(location).body(listaCreada);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/lists/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!listaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        listaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.NO_CONTENT);
    }


}