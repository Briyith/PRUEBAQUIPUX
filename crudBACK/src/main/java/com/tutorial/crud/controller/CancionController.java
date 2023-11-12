package com.tutorial.crud.controller;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.CancionDto;
import com.tutorial.crud.entity.Cancion;
import com.tutorial.crud.service.CancionService;
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
@RequestMapping("/cancion")
@CrossOrigin(origins = "http://localhost:4200")
public class CancionController {

    @Autowired
    CancionService cancionService;

    @GetMapping("/lists")
    public ResponseEntity<List<Cancion>> list(){
        List<Cancion> list = cancionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/lists/{id}")
    public ResponseEntity<Cancion> getById(@PathVariable("id") int id){
        if(!cancionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Cancion cancion = cancionService.getOne(id).get();
        return new ResponseEntity(cancion, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/lists")
    public ResponseEntity<?> create(@RequestBody CancionDto cancionDto){
        try {
            if(StringUtils.isBlank(cancionDto.getTitulo()))
                return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
            if(cancionService.existsByTitulo(cancionDto.getTitulo()))
                return new ResponseEntity(new Mensaje("ese titulo ya existe"), HttpStatus.BAD_REQUEST);
            Cancion cancion = new Cancion(cancionDto.getTitulo(), cancionDto.getArtista(), cancionDto.getAlbum(),cancionDto.getAnno(),cancionDto.getGenero(), cancionDto.getLista());
            cancionService.save(cancion);

            // Construir la URI para la lista creada
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(cancion.getId_cancion())
                    .toUri();

            // Construir el objeto de respuesta que incluye la URI y el contenido de la lista
            CancionDto cancionCreada = new CancionDto(cancion.getTitulo(), cancion.getArtista(), cancion.getAlbum(),cancion.getAnno(),cancion.getGenero(), cancion.getLista());


            // Devolver la respuesta con la URI y el contenido de la lista
            return ResponseEntity.created(location).body(cancionCreada);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/lists/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!cancionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        cancionService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.NO_CONTENT);
    }


}