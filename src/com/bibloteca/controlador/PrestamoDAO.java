package com.bibloteca.controlador;

import com.bibloteca.modelo.Prestamo;
import com.bibloteca.modelo.Libro;
import com.bibloteca.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public void addPrestamo(Prestamo prestamo) throws SQLException {
        String sql = "INSERT INTO Prestamos (usuarioId, libroId, fechaPrestamo, fechaDevolucion, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, prestamo.getUsuario().getId());
            statement.setLong(2, prestamo.getLibro().getId());
            statement.setDate(3, java.sql.Date.valueOf(prestamo.getFechaPrestamo()));
            statement.setDate(4, java.sql.Date.valueOf(prestamo.getFechaDevolucion()));
            statement.setString(5, prestamo.getEstado());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    prestamo.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Failed to add prestamo, no ID obtained.");
                }
            }
        }
    }

    public List<Prestamo> getPrestamosByUsuario(int usuarioId) throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos WHERE usuarioId = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Prestamo prestamo = createPrestamoFromResultSet(resultSet);
                    prestamos.add(prestamo);
                }
            }
        }
        return prestamos;
    }

    private Prestamo createPrestamoFromResultSet(ResultSet resultSet) throws SQLException {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(resultSet.getLong("id"));

        // Obtener el usuario por su ID
        Usuario usuario = getUsuarioById(resultSet.getInt("usuarioId"));
        prestamo.setUsuario(usuario);

        // Obtener el libro por su ID
        Libro libro = getLibroById(resultSet.getLong("libroId"));
        prestamo.setLibro(libro);

        prestamo.setFechaPrestamo(resultSet.getDate("fechaPrestamo").toLocalDate());
        prestamo.setFechaDevolucion(resultSet.getDate("fechaDevolucion").toLocalDate());
        prestamo.setEstado(resultSet.getString("estado"));

        return prestamo;
    }

    private Usuario getUsuarioById(int usuarioId) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.getUsuarioById(usuarioId);
    }

    private Libro getLibroById(long libroId) throws SQLException {
        LibroDAO libroDAO = new LibroDAO();
        return libroDAO.getLibroById(libroId);
    }

    public void updatePrestamo(Prestamo prestamo) throws SQLException {
        String sql = "UPDATE Prestamos SET usuarioId = ?, libroId = ?, fechaPrestamo = ?, fechaDevolucion = ?, estado = ? WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, prestamo.getUsuario().getId());
            statement.setLong(2, prestamo.getLibro().getId());
            statement.setDate(3, java.sql.Date.valueOf(prestamo.getFechaPrestamo()));
            statement.setDate(4, java.sql.Date.valueOf(prestamo.getFechaDevolucion()));
            statement.setString(5, prestamo.getEstado());
            statement.setLong(6, prestamo.getId());
            statement.executeUpdate();
        }
    }

    public void deletePrestamo(long prestamoId) throws SQLException {
        String sql = "DELETE FROM Prestamos WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, prestamoId);
            statement.executeUpdate();
        }
    }

    public Prestamo getPrestamoById(long prestamoId) throws SQLException {
        String sql = "SELECT * FROM Prestamos WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, prestamoId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createPrestamoFromResultSet(resultSet);
                }
            }
        }
        return null;
    }
}
