/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.modelo;

/**
 *
 * @author r3sn0
 */
public class Manga extends Libro {
    private int volumen;
    private String idiomaOriginal;

    public Manga(long id, String titulo, String autor, String genero, int anioPublicacion, int numeroCopias, String tipoLibro, int volumen, String idiomaOriginal) {
        super(id, titulo, autor, genero, anioPublicacion, numeroCopias, "Mangas");
        this.volumen = volumen;
        this.idiomaOriginal = idiomaOriginal;
    }
    
    public Manga(){
        
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }
}
