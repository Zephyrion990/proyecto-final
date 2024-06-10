package com.bibloteca.controlador;

import com.bibloteca.modelo.*;
import com.bibloteca.vista.Bibloteca;
import com.bibloteca.vista.Devolucion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private final Bibloteca view;
    private final LibroDAO libroDAO;
    private final ComicDAO comicDAO;
    private final MangaDAO mangaDAO;
    private final NovelaDAO novelaDAO;

    public BibliotecaController(Bibloteca view) {
        this.view = view;
        this.libroDAO = new LibroDAO();
        this.comicDAO = new ComicDAO();
        this.mangaDAO = new MangaDAO();
        this.novelaDAO = new NovelaDAO();

        initController();
        loadAllLibros();
    }

    private void initController() {
        view.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibros();
            }
        });
        view.btnRentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentarLibro();
            }
        });
        view.btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Devolucion vista = new Devolucion();
                DevolucionController control = new DevolucionController(vista);
                vista.setVisible(true);
            }
        });
    }

    private void loadAllLibros() {
        try {
            List<Libro> libros = new ArrayList<>();
            libros.addAll(libroDAO.listAllLibros());
            showLibros(libros, "Libro");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buscarLibros() {
        System.out.println("Buscando libros...");
        String atributo = view.atributos.getSelectedItem().toString().toLowerCase();
        String valor = view.txtBuscador.getText();
        String tipoLibro = view.tipoLibroCombo.getSelectedItem().toString();

        try {
            List<Libro> libros = new ArrayList<>();
            switch (tipoLibro) {
                case "Libros":
                    libros.addAll(libroDAO.searchLibros(atributo.toLowerCase(), valor));
                    break;
                case "Comics":
                    libros.addAll(comicDAO.searchComics(atributo.toLowerCase(), valor));
                    break;
                case "Mangas":
                    libros.addAll(mangaDAO.searchMangas(atributo.toLowerCase(), valor));
                    break;
                case "Novelas":
                    libros.addAll(novelaDAO.searchNovelas(atributo.toLowerCase(), valor));
                    break;
            }
            showLibros(libros, tipoLibro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showLibros(List<Libro> libros, String tipoLibro) {
        DefaultTableModel model;

        switch (tipoLibro) {
            case "Comics":
                model = new DefaultTableModel(new Object[]{"ID", "Título", "Autor", "Género", "Año Publicación", "Ilustrador", "Editorial", "Copias Disponibles"}, 0);
                break;
            case "Mangas":
                model = new DefaultTableModel(new Object[]{"ID", "Título", "Autor", "Género", "Año Publicación", "Volumen", "Idioma Original", "Copias Disponibles"}, 0);
                break;
            case "Novelas":
                model = new DefaultTableModel(new Object[]{"ID", "Título", "Autor", "Género", "Año Publicación", "Tipo Narrativa", "Copias Disponibles"}, 0);
                break;
            default:
                model = new DefaultTableModel(new Object[]{"ID", "Título", "Autor", "Género", "Año Publicación", "Copias Disponibles"}, 0);
                break;
        }

        for (Libro libro : libros) {
            int copiasDisponibles = libro.getNumeroCopias();
            if (libro instanceof Comic) {
                Comic comic = (Comic) libro;
                model.addRow(new Object[]{comic.getId(), comic.getTitulo(), comic.getAutor(), comic.getGenero(), comic.getAnioPublicacion(), comic.getIlustrador(), comic.getEditorial(), copiasDisponibles});
            } else if (libro instanceof Manga) {
                Manga manga = (Manga) libro;
                model.addRow(new Object[]{manga.getId(), manga.getTitulo(), manga.getAutor(), manga.getGenero(), manga.getAnioPublicacion(), manga.getVolumen(), manga.getIdiomaOriginal(), copiasDisponibles});
            } else if (libro instanceof Novela) {
                Novela novela = (Novela) libro;
                model.addRow(new Object[]{novela.getId(), novela.getTitulo(), novela.getAutor(), novela.getGenero(), novela.getAnioPublicacion(), novela.getTipoNarrativa(), copiasDisponibles});
            } else {
                model.addRow(new Object[]{libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getAnioPublicacion(), copiasDisponibles});
            }
        }

        view.Table.setModel(model);
    }

    private void rentarLibro() {
        int selectedRow = view.Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Por favor, selecciona un libro para rentar.");
            return;
        }

        long libroId = (long) view.Table.getValueAt(selectedRow, 0);

        try {
            Libro libro = libroDAO.getLibroById(libroId);

            if (libro.getNumeroCopias() <= 0) {
                JOptionPane.showMessageDialog(view, "Lo sentimos, no hay copias disponibles para este libro en este momento.");
                return;
            }

            Usuario usuarioActual = ControlUsuarioInicio.getUsuarioActual();

            Prestamo prestamo = new Prestamo();
            prestamo.setUsuario(usuarioActual);
            prestamo.setLibro(libro);
            prestamo.setEstado("Vigente");
            prestamo.setFechaPrestamo(LocalDate.now());
            prestamo.setFechaDevolucion(LocalDate.now().plusDays(7));

            PrestamoDAO prestamoDAO = new PrestamoDAO();
            prestamoDAO.addPrestamo(prestamo);

            String mensaje = "Libro rentado con éxito.\n\n" +
                    "Título: " + libro.getTitulo() + "\n" +
                    "Fecha de préstamo: " + prestamo.getFechaPrestamo() + "\n" +
                    "Fecha de devolución: " + prestamo.getFechaDevolucion();
            updateCopiesInTable(selectedRow, libro);
            updateCopiesInDatabase(libro);

            JOptionPane.showMessageDialog(view, mensaje, "Ticket de Préstamo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Ha ocurrido un error al intentar rentar el libro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCopiesInTable(int selectedRow, Libro libro) {
        DefaultTableModel model = (DefaultTableModel) view.Table.getModel();
        int numColumns = model.getColumnCount();

        for (int i = 0; i < numColumns; i++) {
            if (model.getColumnName(i).equals("Copias Disponibles")) {
                model.setValueAt(libro.getNumeroCopias() - 1, selectedRow, i);
                break;
            }
        }
    }

    private void updateCopiesInDatabase(Libro libro) throws SQLException {
        libro.setNumeroCopias(libro.getNumeroCopias() - 1);
        libroDAO.updateLibro(libro);
    }
}