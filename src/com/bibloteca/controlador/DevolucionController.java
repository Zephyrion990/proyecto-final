/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.controlador;

/**
 *
 * @author r3sn0
 */
import com.bibloteca.vista.Devolucion;
import com.bibloteca.modelo.Usuario;
import com.bibloteca.modelo.Prestamo;
import com.bibloteca.modelo.Libro;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JViewport;

public class DevolucionController {
    private Devolucion view;
    private PrestamoDAO prestamoDAO;

    public DevolucionController(Devolucion view) {
        this.view = view;
        this.prestamoDAO = new PrestamoDAO();
        loadPrestamos();

        view.btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLibro();
            }
        });
    }

    private void loadPrestamos() {
    int usuarioActualId = ControlUsuarioInicio.getUsuarioActual().getId();
    try {
        System.out.println("Cargando préstamos..."+ usuarioActualId);
        List<Prestamo> prestamos = prestamoDAO.getPrestamosByUsuario(usuarioActualId);
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Usuario", "Libro", "Fecha Préstamo", "Fecha Devolución", "Estado"}, 0);

        for (Prestamo prestamo : prestamos) {
            String tituloLibro = (prestamo.getLibro() != null) ? prestamo.getLibro().getTitulo() : "Libro no encontrado";
            String nombreUsuario = (prestamo.getUsuario() != null) ? prestamo.getUsuario().getNombre(): "Usuario no encontrado";
            model.addRow(new Object[]{prestamo.getId(), nombreUsuario, tituloLibro, prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion(), prestamo.getEstado()});
        }

        view.tablaDevolucion.setModel(model);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(view, "Error al cargar los préstamos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void showPrestamos(List<Prestamo> prestamos) {
    DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Usuario", "Libro", "Fecha Préstamo", "Fecha Devolución", "Estado"}, 0);

    for (Prestamo prestamo : prestamos) {
        String tituloLibro = (prestamo.getLibro() != null) ? prestamo.getLibro().getTitulo() : "Libro no encontrado";
        String nombreUsuario = (prestamo.getUsuario() != null) ? prestamo.getUsuario().getNombre(): "Usuario no encontrado";
        model.addRow(new Object[]{prestamo.getId(), nombreUsuario, tituloLibro, prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion(), prestamo.getEstado()});
    }

    // Establecer el modelo de la tabla en la vista de devolución
    view.tablaDevolucion.setModel(model);
}

    private void devolverLibro() {
        // Lógica para devolver un préstamo seleccionado en la tabla
        // ...
    }
}