package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.NamingException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ServicioPost {
    List<Post> findAll();
    Post postFindById(Long id);
    void save(Post post);
    void delete(Post post);
    List<Post> findAllByMatricula(String matricula) ;
    Boolean postFindByEspecialidad(String especialidad,String matricula);
    void update(Post post);

    Resource load(String filename) throws MalformedURLException;

     String copy(MultipartFile file) throws IOException;

     boolean delete(String filename);

    String getUniqueFileName();
    List<Post> postFindByEspecialidad(String especialidad);
    void asignarParametros(Contratado contratado);



    void agregarAFavorito(Long postId, String usuarioConectado);
    Boolean buscarUsuarioYPostEnFavorito(Long postId, String usuarioConectado);
}
