package com.bibloteca.controlador;

import com.bibloteca.modelo.Usuario;
import com.bibloteca.controlador.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apodo, contraseña, gmail, tipoUsuario, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = Conexion.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getApodo());
        statement.setString(3, usuario.getContraseña());
        statement.setString(4, usuario.getGmail());
        statement.setString(5, usuario.getTipoUsuario());
        statement.setString(6, usuario.getTelefono());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        Conexion.disconnect();
        return rowInserted;
    }

    public List<Usuario> listAllUsuarios() throws SQLException {
        List<Usuario> listUsuario = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";
        Connection connection = Conexion.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apodo = resultSet.getString("apodo");
            String contraseña = resultSet.getString("contraseña");
            String gmail = resultSet.getString("gmail");
            String tipoUsuario = resultSet.getString("tipoUsuario");
            String telefono = resultSet.getString("telefono");

            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setApodo(apodo);
            usuario.setContraseña(contraseña);
            usuario.setGmail(gmail);
            usuario.setTipoUsuario(tipoUsuario);
            usuario.setTelefono(telefono);

            listUsuario.add(usuario);
        }

        resultSet.close();
        statement.close();
        Conexion.disconnect();

        return listUsuario;
    }

    public boolean deleteUsuario(Usuario usuario) throws SQLException {
        String sql = "DELETE FROM usuarios where id = ?";
        Connection connection = Conexion.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        Conexion.disconnect();
        return rowDeleted;
    }

    public boolean updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, apodo = ?, contraseña = ?, gmail = ?, tipoUsuario = ?, telefono = ?";
        sql += " WHERE id = ?";
        Connection connection = Conexion.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNombre());
        statement.setString(2, usuario.getApodo());
        statement.setString(3, usuario.getContraseña());
        statement.setString(4, usuario.getGmail());
        statement.setString(5, usuario.getTipoUsuario());
        statement.setString(6, usuario.getTelefono());
        statement.setInt(7, usuario.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        Conexion.disconnect();
        return rowUpdated;
    }

    public Usuario getUsuario(Integer id) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Connection connection = Conexion.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apodo = resultSet.getString("apodo");
            String contraseña = resultSet.getString("contraseña");
            String gmail = resultSet.getString("gmail");
            String tipoUsuario = resultSet.getString("tipoUsuario");
            String telefono = resultSet.getString("telefono");

            usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setApodo(apodo);
            usuario.setContraseña(contraseña);
            usuario.setGmail(gmail);
            usuario.setTipoUsuario(tipoUsuario);
            usuario.setTelefono(telefono);
        }

        resultSet.close();
        statement.close();
        Conexion.disconnect();

        return usuario;
    }
    public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE gmail = ?";
        Connection connection = Conexion.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, correo);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apodo = resultSet.getString("apodo");
            String contraseña = resultSet.getString("contraseña");
            String tipoUsuario = resultSet.getString("tipoUsuario");
            String telefono = resultSet.getString("telefono");

            usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setApodo(apodo);
            usuario.setContraseña(contraseña);
            usuario.setGmail(correo);
            usuario.setTipoUsuario(tipoUsuario);
            usuario.setTelefono(telefono);
        }

        resultSet.close();
        statement.close();
        Conexion.disconnect();

        return usuario;
    }
    
    public Usuario getUsuarioById(int usuarioId) throws SQLException {
        String sql = "SELECT * FROM Usuarios WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    // Establecer otros atributos del usuario según sea necesario
                    return usuario;
                }
            }
        }
        return null;
    }

    private Usuario createUsuarioFromResultSet(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        return usuario;
    }

}

