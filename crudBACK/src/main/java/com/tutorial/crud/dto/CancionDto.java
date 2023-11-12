package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;
import java.util.Date;

import com.tutorial.crud.entity.Lista;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
public class CancionDto {
    @NotBlank
    private String titulo;
    private String artista;

    private String album;

    private Date anno;

    private String genero;

    private Lista lista;



    public CancionDto() {
    }

    public CancionDto(String titulo, String artista, String album, Date anno, String genero, Lista lista) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anno = anno;
        this.genero = genero;
        this.lista = lista;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
