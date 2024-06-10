/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author r3sn0
 */
import com.bibloteca.controlador.BibliotecaController;
import com.bibloteca.controlador.ControlUsuario;
import com.bibloteca.controlador.ControlUsuarioInicio;
import com.bibloteca.controlador.UsuarioDAO;
import com.bibloteca.modelo.Usuario;
import com.bibloteca.vista.AdminEditarLibro;
import com.bibloteca.vista.Bibloteca;
import com.bibloteca.vista.Registro;
import com.bibloteca.vista.InicioSesion;
public class main {
    public static void main(String[] args) {
        //Registro vista = new Registro();
        UsuarioDAO DAO = new UsuarioDAO();
        Usuario user = new Usuario();
        
        /*Bibloteca vista = new Bibloteca();
        BibliotecaController control = new BibliotecaController(vista);*/
        
        //ControlUsuario control = new ControlUsuario(vista, DAO, user);
        //vista.setVisible(true);*/
        
        //AdminEditarLibro vista = new AdminEditarLibro();
        InicioSesion vista = new InicioSesion();
        ControlUsuarioInicio control = new ControlUsuarioInicio(vista, DAO);
        //AdminLibroController control = new AdminLibroController(vista);
        vista.setVisible(true);
        
        
        
        
        
        /*
        adminEditarLibro vista = new adminEditarLibro();
        LibroDAO dao = new LibroDAO();
        Libro libro = new Libro();
        
        controladorLibro controlador = new controladorLibro(vista, dao, libro);

        vista.setVisible(true);*/
        
       /* CheckIn che = new CheckIn();
        UserDAO DAO = new UserDAO();
        Usuario user = new Usuario();
        
        ctlRegistro control = new ctlRegistro(che, DAO, user);
        che.setVisible(true);*/
       
        /*CheckPerso admRegPer = new CheckPerso();
        PersonaDAO perDAO = new PersonaDAO();
        Persona persona = new Persona();
        
        ctlRegistroPer control = new ctlRegistroPer(admRegPer, perDAO, persona);
        admRegPer.setVisible(true);*/
    }
}