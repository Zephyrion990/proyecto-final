/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.modelo;

/**
 *
 * @author r3sn0
 */
public class Novela extends Libro {
    private String tipoNarrativa;

    // Constructor, getters y setters
    public Novela(long id, String titulo, String autor, String genero, int anioPublicacion, int numeroCopias, String tipoLibro, String tipoNarrativa) {
        super(id, titulo, autor, genero, anioPublicacion, numeroCopias, tipoLibro);
        this.tipoNarrativa = tipoNarrativa;
    }
    public Novela(){
        
    }

    public String getTipoNarrativa() {
        return tipoNarrativa;
    }

    public void setTipoNarrativa(String tipoNarrativa) {
        this.tipoNarrativa = tipoNarrativa;
    }
}


