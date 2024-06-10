package com.bibloteca.controlador;

import com.bibloteca.controlador.Conexion;
import com.bibloteca.modelo.Comic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComicDAO {
    
     private final LibroDAO libroDAO;

    public ComicDAO() {
        this.libroDAO = new LibroDAO();
    }

    public List<Comic> listAllComics() throws SQLException {
        List<Comic> comics = new ArrayList<>();
        String sql = "SELECT * FROM Comics JOIN Libros ON Comics.libroId = Libros.id";
        
        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                Comic comic = createComicFromResultSet(resultSet);
                comics.add(comic);
            }
        }
        
        return comics;
    }

    private Comic createComicFromResultSet(ResultSet resultSet) throws SQLException {
        Comic comic = new Comic();
        comic.setId(resultSet.getLong("id"));
        comic.setTitulo(resultSet.getString("titulo"));
        comic.setAutor(resultSet.getString("autor"));
        comic.setGenero(resultSet.getString("genero"));
        comic.setAnioPublicacion(resultSet.getInt("anioPublicacion"));
        comic.setNumeroCopias(resultSet.getInt("numeroCopias"));
        comic.setIlustrador(resultSet.getString("ilustrador"));
        comic.setEditorial(resultSet.getString("editorial"));
        return comic;
    }
    
    public List<Comic> searchComics(String atributo, String valor) throws SQLException {
    List<Comic> comics = new ArrayList<>();
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
        case "numerocopias":
            columnName = "Libros.numeroCopias";
            break;
        case "ilustrador":
            columnName = "Comics.ilustrador";
            break;
        case "editorial":
            columnName = "Comics.editorial";
            break;
        case "id":
            columnName = "Comics.id";
            break;
        case "libroid":
            columnName = "Comics.libroId";
            break;
        default:
            throw new IllegalArgumentException("Atributo desconocido: " + atributo);
    }

    String sql = "SELECT Comics.*, Libros.titulo, Libros.autor, Libros.genero, Libros.anioPublicacion, Libros.numeroCopias " +
                 "FROM Comics " +
                 "INNER JOIN Libros ON Comics.libroId = Libros.id " +
                 "WHERE " + columnName + " LIKE ?";

    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, "%" + valor + "%");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Comic comic = createComicFromResultSet(resultSet);
                comics.add(comic);
            }
        }
    }

        return comics;
    }
    
    public void insertarComic(Comic comic) throws SQLException {
        long libroId = libroDAO.insertarLibro(comic);
        String sql = "INSERT INTO Comics (libroId, ilustrador, editorial) VALUES (?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, libroId);
            statement.setString(2, comic.getIlustrador());
            statement.setString(3, comic.getEditorial());
            statement.executeUpdate();
        }
    }


}
