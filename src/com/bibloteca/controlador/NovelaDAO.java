package com.bibloteca.controlador;

import com.bibloteca.controlador.*;
import com.bibloteca.modelo.Novela;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NovelaDAO {
    
    private final LibroDAO libroDAO;

    public NovelaDAO() {
        this.libroDAO = new LibroDAO();
    }

    public List<Novela> listAllNovelas() throws SQLException {
        List<Novela> novelas = new ArrayList<>();
        String sql = "SELECT * FROM Novelas JOIN Libros ON Novelas.libroId = Libros.id";
        
        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Novela novela = createNovelaFromResultSet(resultSet);
                novelas.add(novela);
            }
        }
        
        return novelas;
    }

    private Novela createNovelaFromResultSet(ResultSet resultSet) throws SQLException {
        Novela novela = new Novela();
        novela.setId(resultSet.getLong("id"));
        novela.setTitulo(resultSet.getString("titulo"));
        novela.setAutor(resultSet.getString("autor"));
        novela.setGenero(resultSet.getString("genero"));
        novela.setAnioPublicacion(resultSet.getInt("anioPublicacion"));
        novela.setNumeroCopias(resultSet.getInt("numeroCopias"));
        novela.setTipoNarrativa(resultSet.getString("tipoNarrativa"));
        return novela;
    }
    
    public List<Novela> searchNovelas(String atributo, String valor) throws SQLException {
    List<Novela> novelas = new ArrayList<>();
    String columnName;

    switch (atributo.toLowerCase()) {
        case "titulo":
            columnName = "Libros.titulo";
            break;
        case "autor":
            columnName = "Libros.autor";
            break;
        case "genero":
            columnName = "Libros.genero";
            break;
        case "año de publicacion":
            columnName = "Libros.anioPublicacion";
            break;
        case "numero de copias":
            columnName = "Libros.numeroCopias";
            break;
        case "tipolibro":
            columnName = "Libros.tipoLibro";
            break;
        case "tipo narrativa":
            columnName = "Novelas.tipoNarrativa";
            break;
        case "id":
            columnName = "Novelas.id";
            break;
        case "libroid":
            columnName = "Novelas.libroId";
            break;
        default:
            throw new IllegalArgumentException("Atributo desconocido: " + atributo);
    }

    String sql = "SELECT Novelas.*, Libros.titulo, Libros.autor, Libros.genero, Libros.anioPublicacion, Libros.numeroCopias " +
             "FROM Novelas " +
             "JOIN Libros ON Novelas.libroId = Libros.id " +
             "WHERE " + columnName + " LIKE ?";
    
    try (Connection connection = Conexion.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, "%" + valor + "%");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Novela novela = createNovelaFromResultSet(resultSet);
                novelas.add(novela);
            }
        }
    }

    return novelas;
}
    public void insertarNovela(Novela novela) throws SQLException {
        long libroId = libroDAO.insertarLibro(novela);
        String sql = "INSERT INTO Novelas (libroId, tipoNarrativa) VALUES (?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, libroId);
            statement.setString(2, novela.getTipoNarrativa());
            statement.executeUpdate();
        }
    }

}
