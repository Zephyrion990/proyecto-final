/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.controlador;
import com.bibloteca.controlador.UsuarioDAO;
import com.bibloteca.vista.InicioSesion;
import com.bibloteca.modelo.Usuario;
import com.bibloteca.vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author r3sn0
 */
public class ControlUsuarioInicio implements ActionListener {
    private InicioSesion inicioSesion;
    private UsuarioDAO usuarioDAO;
    private static Usuario usuarioActual; // Variable estática para almacenar el usuario actual

    public ControlUsuarioInicio(InicioSesion inicioSesion, UsuarioDAO usuarioDAO) {
        this.inicioSesion = inicioSesion;
        this.usuarioDAO = usuarioDAO;

        this.inicioSesion.btnCancelar.addActionListener(this);
        this.inicioSesion.bntIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicioSesion.bntIngresar) {
            String correo = inicioSesion.txtCorreo.getText();
            String contraseña = new String(inicioSesion.txtpass.getPassword());

            if (!correo.isEmpty() && !contraseña.isEmpty()) {
                try {
                    Usuario usuario = usuarioDAO.obtenerUsuarioPorCorreo(correo);
                    if (usuario != null) {
                        if (usuario.getContraseña().equals(contraseña)) {
                            usuarioActual = usuario; // Almacenar el usuario actual
                            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                            if(usuarioActual.getTipoUsuario().equalsIgnoreCase("admin")){
                                UsuarioDAO DAO = new UsuarioDAO();
                                Usuario user = new Usuario();

                                InicioUsuarioAdmin vista = new InicioUsuarioAdmin();
                                vista.setVisible(true);
                                inicioSesion.dispose();
                            }else{
                                UsuarioDAO DAO = new UsuarioDAO();
                                Usuario user = new Usuario();

                                InicioUsuario vista = new InicioUsuario();
                                vista.setVisible(true);
                                inicioSesion.dispose();
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Correo electrónico no encontrado");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese correo y contraseña");
            }
        }
        if (e.getSource() == inicioSesion.btnCancelar) {
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        inicioSesion.txtCorreo.setText("");
        inicioSesion.txtpass.setText("");
    }

    // Método estático para obtener el usuario actualmente logueado
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
}