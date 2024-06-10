package com.bibloteca.controlador;

import com.bibloteca.modelo.Comic;
import com.bibloteca.modelo.Libro;
import com.bibloteca.modelo.Manga;
import com.bibloteca.modelo.Novela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLibroController {
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField generoField;
    private JTextField anioField;
    private JTextField copiasField;
    private JTextField tipoField;
    private JTextField volumenField;
    private JTextField demografiaField;
    private JTextField ilustradorField;
    private JTextField editorialField;
    private JTextField tipoNarrativaField;
    private JButton crearButton;

    private LibroDAO libroDAO;
    private MangaDAO mangaDAO;
    private ComicDAO comicDAO;
    private NovelaDAO novelaDAO;

    public AdminLibroController() {
        libroDAO = new LibroDAO();
        mangaDAO = new MangaDAO();
        comicDAO = new ComicDAO();
        novelaDAO = new NovelaDAO();

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearLibro();
            }
        });
    }

    private void crearLibro() {
        String titulo = tituloField.getText();
        String autor = autorField.getText();
        String genero = generoField.getText();
        int anioPublicacion = Integer.parseInt(anioField.getText());
        int numeroCopias = Integer.parseInt(copiasField.getText());
        String tipoLibro = tipoField.getText();

        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setGenero(genero);
        libro.setAnioPublicacion(anioPublicacion);
        libro.setNumeroCopias(numeroCopias);
        libro.setTipoLibro(tipoLibro);

        try {
            switch (tipoLibro.toLowerCase()) {
                case "manga":
                    Manga manga = new Manga();
                    manga.setTitulo(titulo);
                    manga.setAutor(autor);
                    manga.setGenero(genero);
                    manga.setAnioPublicacion(anioPublicacion);
                    manga.setNumeroCopias(numeroCopias);
                    manga.setVolumen(Integer.parseInt(volumenField.getText()));
                    manga.setIdiomaOriginal(demografiaField.getText());
                    mangaDAO.insertarManga(manga);
                    break;
                case "comic":
                    Comic comic = new Comic();
                    comic.setTitulo(titulo);
                    comic.setAutor(autor);
                    comic.setGenero(genero);
                    comic.setAnioPublicacion(anioPublicacion);
                    comic.setNumeroCopias(numeroCopias);
                    comic.setIlustrador(ilustradorField.getText());
                    comic.setEditorial(editorialField.getText());
                    comicDAO.insertarComic(comic);
                    break;
                case "novela":
                    Novela novela = new Novela();
                    novela.setTitulo(titulo);
                    novela.setAutor(autor);
                    novela.setGenero(genero);
                    novela.setAnioPublicacion(anioPublicacion);
                    novela.setNumeroCopias(numeroCopias);
                    novela.setTipoNarrativa(tipoNarrativaField.getText());
                    novelaDAO.insertarNovela(novela);
                    break;
                default:
                    libroDAO.insertarLibro(libro);
                    break;
            }
            JOptionPane.showMessageDialog(null, "Libro creado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el libro: " + e.getMessage());
        }
    }
}