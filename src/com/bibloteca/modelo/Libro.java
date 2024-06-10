/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.modelo;

/**
 *
 * @author r3sn0
 */
import java.util.List;

public class Libro {
    private long id;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private int numeroCopias;
    private String tipoLibro;

    // Constructor, getters y setters
    public Libro(long id, String titulo, String autor, String genero, int anioPublicacion, int numeroCopias, String tipoLibro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.numeroCopias = numeroCopias;
        this.tipoLibro = tipoLibro;
    }
    public Libro(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }
    
    public int getNumCopiasDisponibles() {
        return this.numeroCopias;
    }
}
