package com.bibloteca.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaBusqueda extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;

    public TablaBusqueda() {
        setTitle("Resultados de Búsqueda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Crear el modelo de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Autor");
        modelo.addColumn("Tipo");

        // Crear la tabla con el modelo
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Botón "Rentar"
        JButton btnRentar = new JButton("Rentar");
        btnRentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Obtener los datos de la fila seleccionada
                    int id = (int) modelo.getValueAt(filaSeleccionada, 0);
                    String tipoLibro = (String) modelo.getValueAt(filaSeleccionada, 3);

                    // Realizar la acción de rentar utilizando los datos obtenidos
                    // Aquí puedes implementar la lógica para rentar el libro con el ID y tipoLibro
                    JOptionPane.showMessageDialog(null, "Rentar libro con ID: " + id + ", Tipo: " + tipoLibro);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un libro de la tabla para rentar.");
                }
            }
        });

        // Panel para el botón "Rentar"
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnRentar);

        // Añadir componentes al contenedor principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBoton, BorderLayout.SOUTH);
    }

    // Método para agregar una fila a la tabla
    public void agregarFila(Object[] rowData) {
        modelo.addRow(rowData);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TablaBusqueda tablaBusqueda = new TablaBusqueda();
                tablaBusqueda.setVisible(true);
                
                // Ejemplo: Agregar filas de ejemplo a la tabla
                tablaBusqueda.agregarFila(new Object[]{1, "Libro 1", "Autor 1", "Novela"});
                tablaBusqueda.agregarFila(new Object[]{2, "Libro 2", "Autor 2", "Cómic"});
                tablaBusqueda.agregarFila(new Object[]{3, "Libro 3", "Autor 3", "Manga"});
            }
        });
    }
}
