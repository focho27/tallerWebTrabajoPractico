package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPost;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.NamingException;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorPefilTest extends SpringTest {
 /*   private final Usuario USUARIO = usuario("H12B09","prueba@gmail.com", "123123");
    private final Post POST = post("H12B09","Riki Fort");
    private final String MATRICULA= USUARIO.getMatricula();
    @Autowired
    private RepositorioPost repositorioPost;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ControladorPerfil controladorPerfil ;
    private ModelAndView mav;


    @Test
    @Transactional
    @Rollback
    public void queSeVeaPerfilUsuarioConMatriculaValida()  {
        giveUsuarioConMatriculaValida(USUARIO);
        whenAccedoAPerfil(MATRICULA);
        thenVeoPerfilConUsuarioYSusPost("usuario","posts");
    }

    private void thenVeoPerfilConUsuarioYSusPost(String usuario,String posts) {
        List<Post> posteos=repositorioPost.findAllByMatricula(USUARIO.getMatricula());

        assertThat(mav.getModel().get(usuario)).isEqualTo(USUARIO);
        assertThat(mav.getModel().get(posts)).isEqualTo(posteos);
        assertThat(mav.getViewName()).isEqualTo("perfilUsuario");
    }

    private void whenAccedoAPerfil(String matricula)  {

        mav=controladorPerfil.verPerfilUsuario(matricula);
    }

    private void giveUsuarioConMatriculaValida(Usuario usuario) {
        repositorioUsuario.save(usuario);
        repositorioPost.save(POST);
    }


    public Post post(String matricula, String nombre){
        Post post = new Post();
        post.setMatricula(matricula);
        post.setNombre(nombre);
        return post;
    }
    private Usuario usuario(String matricula,String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setMatricula(matricula);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }*/
}
