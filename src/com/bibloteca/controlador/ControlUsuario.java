/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibloteca.controlador;
import com.bibloteca.modelo.Usuario;
import com.bibloteca.vista.InicioSesion;
import com.bibloteca.vista.Registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlUsuario implements ActionListener {
    private Registro registro;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;

    public ControlUsuario(Registro registro, UsuarioDAO usuarioDAO, Usuario usuario) {
        this.registro = registro;
        this.usuarioDAO = usuarioDAO;
        this.usuario = usuario;

        this.registro.btnCancelar.addActionListener(this);
        this.registro.btnRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registro.btnRegistrar) {
            if (validarCampos()) {
                try {
                    usuario.setNombre(registro.txtNombre.getText());
                    usuario.setApodo(registro.txtApodo.getText());
                    usuario.setContraseña(new String(registro.txtPass.getPassword()));
                    usuario.setGmail(registro.txtCorreo.getText());
                    usuario.setTelefono(registro.txtTelefono.getText());
                    usuario.setTipoUsuario("USUARIO"); 

                    boolean isCreated = usuarioDAO.insertUsuario(usuario);
                    if (isCreated) {
                        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
                        UsuarioDAO DAO = new UsuarioDAO();
                        Usuario user = new Usuario();
                        InicioSesion vista = new InicioSesion();
                        ControlUsuarioInicio control = new ControlUsuarioInicio(vista, DAO);
                        vista.setVisible(true);
                        registro.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de los datos: " + ex.getMessage());
                } catch (SQLException ex) {
                    Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al capturar los datos, inténtelo otra vez");
            }
        }
        if (e.getSource() == registro.btnCancelar) {
            limpiarCampos();
        }
    }

    private boolean validarCampos() {
        if (!noVacio()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return false;
        }
        if (!validarContraseña()) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return false;
        }
        return true;
    }

    private boolean noVacio() {
        return !registro.txtNombre.getText().isEmpty() &&
               !registro.txtApodo.getText().isEmpty() &&
               !registro.txtCorreo.getText().isEmpty() &&
               !registro.txtTelefono.getText().isEmpty() &&
               registro.txtPass.getPassword().length > 0 &&
               registro.txtPassConf.getPassword().length > 0;
    }

    private boolean validarContraseña() {
        String pass = new String(registro.txtPass.getPassword());
        String passConf = new String(registro.txtPassConf.getPassword());
        return pass.equals(passConf);
    }

    private void limpiarCampos() {
        registro.txtNombre.setText("");
        registro.txtApodo.setText("");
        registro.txtCorreo.setText("");
        registro.txtTelefono.setText("");
        registro.txtPass.setText("");
        registro.txtPassConf.setText("");
    }
}

