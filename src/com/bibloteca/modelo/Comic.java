/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.modelo;

/**
 *
 * @author r3sn0
 */
public class Comic extends Libro {
    private String ilustrador;
    private String editorial;

    // Constructor, getters y setters
    public Comic(long id, String titulo, String autor, String genero, int anioPublicacion, int numeroCopias, String tipoLibro, String ilustrador, String editorial) {
        super(id, titulo, autor, genero, anioPublicacion, numeroCopias, "Comics");
        this.ilustrador = ilustrador;
        this.editorial = editorial;
    }
    public Comic(){
        
    }

    public String getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(String ilustrador) {
        this.ilustrador = ilustrador;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
