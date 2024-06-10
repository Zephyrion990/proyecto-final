package com.bibloteca.controlador;

import com.bibloteca.controlador.Conexion;
import com.bibloteca.modelo.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaDAO {
     private final LibroDAO libroDAO;

    public MangaDAO() {
        this.libroDAO = new LibroDAO();
    }
    

    public List<Manga> listAllMangas() throws SQLException {
        List<Manga> mangas = new ArrayList<>();
        String sql = "SELECT * FROM Mangas JOIN Libros ON Mangas.libroId = Libros.id";

        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Manga manga = createMangaFromResultSet(resultSet);
                mangas.add(manga);
            }
        }

        return mangas;
    }

    public List<Manga> searchMangas(String atributo, String valor) throws SQLException {
    List<Manga> mangas = new ArrayList<>();
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
        case "volumen":
            columnName = "Mangas.volumen";
            break;
        case "capitulos":
            columnName = "Mangas.capitulos";
            break;
        case "demografia":
            columnName = "Mangas.demografia";
            break;
        case "id":
            columnName = "Mangas.id";
            break;
        case "libroid":
            columnName = "Mangas.libroId";
            break;
        default:
            throw new IllegalArgumentException("Atributo desconocido: " + atributo);
    }

    String sql = "SELECT Mangas.*, Libros.titulo, Libros.autor, Libros.genero, Libros.anioPublicacion, Libros.numeroCopias " +
                 "FROM Mangas " +
                 "JOIN Libros ON Mangas.libroId = Libros.id " +
                 "WHERE " + columnName + " LIKE ?";

    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, "%" + valor + "%");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Manga manga = createMangaFromResultSet(resultSet);
                mangas.add(manga);
            }
        }
    }

    return mangas;
}



    private Manga createMangaFromResultSet(ResultSet resultSet) throws SQLException {
        Manga manga = new Manga();
        manga.setId(resultSet.getLong("id"));
        manga.setTitulo(resultSet.getString("titulo"));
        manga.setAutor(resultSet.getString("autor"));
        manga.setGenero(resultSet.getString("genero"));
        manga.setAnioPublicacion(resultSet.getInt("anioPublicacion"));
        manga.setNumeroCopias(resultSet.getInt("numeroCopias"));
        manga.setVolumen(resultSet.getInt("volumen"));
        manga.setIdiomaOriginal(resultSet.getString("idiomaOriginal"));
        return manga;
    }
    
public void insertarManga(Manga manga) throws SQLException {
    String sqlLibro = "INSERT INTO Libro (titulo, autor, genero, anioPublicacion, numeroCopias, tipoLibro) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection connection = Conexion.getConnection();
         PreparedStatement statement = connection.prepareStatement(sqlLibro, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, manga.getTitulo());
        statement.setString(2, manga.getAutor());
        statement.setString(3, manga.getGenero());
        statement.setInt(4, manga.getAnioPublicacion());
        statement.setInt(5, manga.getNumeroCopias());
        statement.setString(6, manga.getTipoLibro());
        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("La inserción del libro falló, no se generó ningún ID.");
        }
        
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long libroId = generatedKeys.getLong(1); // Obtiene el ID autoincremental generado
                // Ahora que tienes el ID del libro, puedes insertar el manga en la tabla Mangas
                String sqlManga = "INSERT INTO Mangas (libroId, volumen, demografia) VALUES (?, ?, ?)";
                try (PreparedStatement mangaStatement = connection.prepareStatement(sqlManga)) {
                    mangaStatement.setLong(1, libroId);
                    mangaStatement.setInt(2, manga.getVolumen());
                    mangaStatement.setString(3, manga.getIdiomaOriginal());
                    mangaStatement.executeUpdate();
                }
            } else {
                throw new SQLException("La inserción del libro falló, no se generó ningún ID.");
            }
        }
    }
}
}
