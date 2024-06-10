package com.bibloteca.controlador;

import com.bibloteca.controlador.Conexion;
import com.bibloteca.modelo.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public List<Libro> listAllLibros() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros";
        
        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Libro libro = createLibroFromResultSet(resultSet);
                libros.add(libro);
            }
        }
        
        return libros;
    }

    private Libro createLibroFromResultSet(ResultSet resultSet) throws SQLException {
        Libro libro = new Libro();
        libro.setId(resultSet.getLong("id"));
        libro.setTitulo(resultSet.getString("titulo"));
        libro.setAutor(resultSet.getString("autor"));
        libro.setGenero(resultSet.getString("genero"));
        libro.setAnioPublicacion(resultSet.getInt("anioPublicacion"));
        libro.setNumeroCopias(resultSet.getInt("numeroCopias"));
        libro.setTipoLibro(resultSet.getString("tipoLibro"));
        return libro;
    }
    
    public List<Libro> searchLibros(String atributo, String valor) throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE " + atributo + " LIKE ?";
        Connection connection = Conexion.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + valor + "%");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Libro libro = createLibroFromResultSet(resultSet);
            libros.add(libro);
        }

        resultSet.close();
        statement.close();
        Conexion.disconnect();

        return libros;
    }
    public Libro getLibroById(long id) throws SQLException {
    String sql = "SELECT * FROM Libros WHERE id = ?";
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setLong(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return createLibroFromResultSet(resultSet);
            }
        }
    }
    return null; // Si no se encuentra ningún libro con el ID especificado
}

public void updateLibro(Libro libro) throws SQLException {
    String sql = "UPDATE Libros SET titulo = ?, autor = ?, genero = ?, anioPublicacion = ?, numeroCopias = ?, tipoLibro = ? WHERE id = ?";
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, libro.getTitulo());
        statement.setString(2, libro.getAutor());
        statement.setString(3, libro.getGenero());
        statement.setInt(4, libro.getAnioPublicacion());
        statement.setInt(5, libro.getNumeroCopias());
        statement.setString(6, libro.getTipoLibro());
        statement.setLong(7, libro.getId());
        statement.executeUpdate();
    }
}
public void incrementarDisponibilidad(long libroId) throws SQLException {
        String sql = "UPDATE Libros SET cantidadDisponible = cantidadDisponible + 1 WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, libroId);
            statement.executeUpdate();
        }
    }
    public int insertarLibro(Libro libro) throws SQLException {
        String sql = "INSERT INTO Libros (titulo, autor, genero, anioPublicacion, numeroCopias, tipoLibro) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        int libroId = -1;
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getGenero());
            statement.setInt(4, libro.getAnioPublicacion());
            statement.setInt(5, libro.getNumeroCopias());
            statement.setString(6, libro.getTipoLibro());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                libroId = generatedKeys.getInt(1);
            }
        }
        return libroId;
    }
}