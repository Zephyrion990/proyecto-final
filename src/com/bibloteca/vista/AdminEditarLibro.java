/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bibloteca.vista;

import com.bibloteca.controlador.*;
import com.bibloteca.modelo.Libro;

/**
 *
 * @author r3sn0
 */
public class AdminEditarLibro extends javax.swing.JFrame {

    /**
     * Creates new form adminEditarLibro
     */
    public AdminEditarLibro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        barraNavSup = new javax.swing.JPanel();
        bgPrincipal = new javax.swing.JPanel();
        btnPrincipal = new javax.swing.JLabel();
        bgPerfil = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JLabel();
        bgLibreria = new javax.swing.JPanel();
        btnLibreria = new javax.swing.JLabel();
        tabla = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        txtTipoLibro = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        lblCopias = new javax.swing.JLabel();
        txtPublicacion = new javax.swing.JTextField();
        lblPublicacion = new javax.swing.JLabel();
        txtCopias = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(900, 500));
        setResizable(false);

        bg.setBackground(new java.awt.Color(236, 240, 241));
        bg.setMaximumSize(new java.awt.Dimension(900, 500));
        bg.setMinimumSize(new java.awt.Dimension(900, 500));
        bg.setPreferredSize(new java.awt.Dimension(900, 500));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraNavSup.setBackground(new java.awt.Color(44, 62, 80));

        bgPrincipal.setBackground(new java.awt.Color(40, 62, 80));
        bgPrincipal.setMaximumSize(new java.awt.Dimension(290, 60));
        bgPrincipal.setMinimumSize(new java.awt.Dimension(290, 600));
        bgPrincipal.setPreferredSize(new java.awt.Dimension(290, 60));

        btnPrincipal.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrincipal.setText("Principal");
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.setPreferredSize(new java.awt.Dimension(290, 60));

        javax.swing.GroupLayout bgPrincipalLayout = new javax.swing.GroupLayout(bgPrincipal);
        bgPrincipal.setLayout(bgPrincipalLayout);
        bgPrincipalLayout.setHorizontalGroup(
            bgPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgPrincipalLayout.setVerticalGroup(
            bgPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPrincipalLayout.createSequentialGroup()
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bgPerfil.setBackground(new java.awt.Color(40, 62, 80));
        bgPerfil.setMaximumSize(new java.awt.Dimension(290, 60));
        bgPerfil.setMinimumSize(new java.awt.Dimension(290, 600));
        bgPerfil.setPreferredSize(new java.awt.Dimension(290, 60));

        btnPerfil.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPerfil.setText("Perfil");
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.setPreferredSize(new java.awt.Dimension(290, 60));

        javax.swing.GroupLayout bgPerfilLayout = new javax.swing.GroupLayout(bgPerfil);
        bgPerfil.setLayout(bgPerfilLayout);
        bgPerfilLayout.setHorizontalGroup(
            bgPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgPerfilLayout.setVerticalGroup(
            bgPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPerfilLayout.createSequentialGroup()
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bgLibreria.setBackground(new java.awt.Color(40, 62, 80));
        bgLibreria.setMaximumSize(new java.awt.Dimension(290, 60));
        bgLibreria.setMinimumSize(new java.awt.Dimension(290, 600));
        bgLibreria.setPreferredSize(new java.awt.Dimension(290, 60));

        btnLibreria.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnLibreria.setForeground(new java.awt.Color(255, 255, 255));
        btnLibreria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLibreria.setText("Adminstracion");
        btnLibreria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibreria.setPreferredSize(new java.awt.Dimension(290, 60));

        javax.swing.GroupLayout bgLibreriaLayout = new javax.swing.GroupLayout(bgLibreria);
        bgLibreria.setLayout(bgLibreriaLayout);
        bgLibreriaLayout.setHorizontalGroup(
            bgLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLibreriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLibreria, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        bgLibreriaLayout.setVerticalGroup(
            bgLibreriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLibreriaLayout.createSequentialGroup()
                .addComponent(btnLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout barraNavSupLayout = new javax.swing.GroupLayout(barraNavSup);
        barraNavSup.setLayout(barraNavSupLayout);
        barraNavSupLayout.setHorizontalGroup(
            barraNavSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraNavSupLayout.createSequentialGroup()
                .addComponent(bgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bgLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(bgPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraNavSupLayout.setVerticalGroup(
            barraNavSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraNavSupLayout.createSequentialGroup()
                .addGroup(barraNavSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bgLibreria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(barraNavSupLayout.createSequentialGroup()
                .addComponent(bgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(barraNavSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 60));

        tabla.setBackground(new java.awt.Color(153, 153, 153));
        tabla.setMaximumSize(new java.awt.Dimension(650, 400));
        tabla.setPreferredSize(new java.awt.Dimension(650, 300));

        lblID.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(0, 0, 0));
        lblID.setText("ID libro:");

        txtAutor.setBackground(new java.awt.Color(255, 255, 255));
        txtAutor.setForeground(new java.awt.Color(0, 0, 0));
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        lblAutor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(0, 0, 0));
        lblAutor.setText("Autor:");

        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setForeground(new java.awt.Color(0, 0, 0));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Titulo:");

        txtTitulo.setBackground(new java.awt.Color(255, 255, 255));
        txtTitulo.setForeground(new java.awt.Color(0, 0, 0));
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        lblEditorial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblEditorial.setForeground(new java.awt.Color(0, 0, 0));
        lblEditorial.setText("Tipo libro:");

        txtTipoLibro.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoLibro.setForeground(new java.awt.Color(0, 0, 0));
        txtTipoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoLibroActionPerformed(evt);
            }
        });

        lblGenero.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(0, 0, 0));
        lblGenero.setText("Genero:");

        txtGenero.setBackground(new java.awt.Color(255, 255, 255));
        txtGenero.setForeground(new java.awt.Color(0, 0, 0));
        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });

        lblCopias.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCopias.setForeground(new java.awt.Color(0, 0, 0));
        lblCopias.setText("Copias:");

        txtPublicacion.setBackground(new java.awt.Color(255, 255, 255));
        txtPublicacion.setForeground(new java.awt.Color(0, 0, 0));
        txtPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublicacionActionPerformed(evt);
            }
        });

        lblPublicacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPublicacion.setForeground(new java.awt.Color(0, 0, 0));
        lblPublicacion.setText("Año publi:");

        txtCopias.setBackground(new java.awt.Color(255, 255, 255));
        txtCopias.setForeground(new java.awt.Color(0, 0, 0));
        txtCopias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCopiasActionPerformed(evt);
            }
        });

        lbl1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(0, 0, 0));
        lbl1.setText("Copias:");

        txt1.setBackground(new java.awt.Color(255, 255, 255));
        txt1.setForeground(new java.awt.Color(0, 0, 0));
        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 0, 0));
        lbl2.setText("Copias:");

        txt2.setBackground(new java.awt.Color(255, 255, 255));
        txt2.setForeground(new java.awt.Color(0, 0, 0));
        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tablaLayout = new javax.swing.GroupLayout(tabla);
        tabla.setLayout(tablaLayout);
        tablaLayout.setHorizontalGroup(
            tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(lblCopias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablaLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(txtCopias)))
                            .addGroup(tablaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt1)))
                        .addGap(30, 30, 30))
                    .addGroup(tablaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        tablaLayout.setVerticalGroup(
            tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablaLayout.createSequentialGroup()
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPublicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPublicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        bg.add(tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 680, -1));

        btnCrear.setBackground(new java.awt.Color(0, 153, 153));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        bg.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 200, 36));

        btnEditar.setBackground(new java.awt.Color(0, 153, 153));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        bg.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 93, 36));

        btnLimpiar.setBackground(new java.awt.Color(0, 153, 153));
        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        bg.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, 36));

        btnBuscar.setBackground(new java.awt.Color(0, 153, 153));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        bg.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 87, 36));

        btnEliminar.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        bg.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, 36));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtTipoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoLibroActionPerformed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublicacionActionPerformed

    private void txtCopiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCopiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCopiasActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminEditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEditarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminEditarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraNavSup;
    public javax.swing.JPanel bg;
    private javax.swing.JPanel bgLibreria;
    private javax.swing.JPanel bgPerfil;
    private javax.swing.JPanel bgPrincipal;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JLabel btnLibreria;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel btnPerfil;
    private javax.swing.JLabel btnPrincipal;
    public javax.swing.JLabel lbl1;
    public javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCopias;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPublicacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel tabla;
    public javax.swing.JTextField txt1;
    public javax.swing.JTextField txt2;
    public javax.swing.JTextField txtAutor;
    public javax.swing.JTextField txtCopias;
    public javax.swing.JTextField txtGenero;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtPublicacion;
    public javax.swing.JTextField txtTipoLibro;
    public javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
