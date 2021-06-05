package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface RepositorioPost {

    List<Post> findAll();
    Post postFindById(Long id);
    void save(Post post);
    void delete(Post post);
    List<Post> findAllByMatricula(String matricula);
    Boolean postFindByEspecialidadAndMatricula(String especialidad, String matricula);
    void update(Post post);
    List<Post> postFindByEspecialidad(String especialidad);

}
