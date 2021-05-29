package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPost;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorPostTest extends SpringTest {
    private final Usuario USUARIO = usuario("H12B09","prueba@gmail.com", "123123");
    private final Post POST = post("H12B09","Riki Fort");
    @Autowired
    private RepositorioPost repositorioPost;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ControladorPost controladorPost ;
    private ModelAndView mav;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaCrearUnPosteoParaUsuarioConMatriculaExistente(){
        givePosteoSinGuardarParaUsuarioCreado(USUARIO);
        whenGuardoPost(POST);
        thenVeoPostEnInicio();
    }
    @Test
    @Transactional
    @Rollback
    public void queNoSePuedaCrearUnPosteoPorqueNoHayUsuarioConMatriculaExistente(){
        givePosteoSinGuardarParaUsuarioCreado(USUARIO);
        whenGuardoPostConMatriculaDiferente(POST);
        thenVeoErrorPostNoCreado("No se puede porque no existe el usaurio con esa matricula");
    }

    private void thenVeoErrorPostNoCreado(String motivo) {
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);
        assertThat(mav.getViewName()).isEqualTo("postsForm");
    }

    private void whenGuardoPostConMatriculaDiferente(Post post) {
        post.setMatricula("ABK19");
       mav= controladorPost.guardarPost(post);
    }

    private void thenVeoPostEnInicio() {
        //assertThat(mav.getModel().get("posts")).isEqualTo();
        mav =controladorPost.viewPosts();
        List<Post> posts = repositorioPost.findAll();
        ModelMap mp =new ModelMap();
        mp.put("posts",posts);
        assertThat(mav.getViewName()).isEqualTo("postsHome");
        assertThat(mav.getModel()).isEqualTo(mp);
    }

    private void whenGuardoPost(Post post) {
        controladorPost.guardarPost(post);

    }

    private void givePosteoSinGuardarParaUsuarioCreado(Usuario usuario) {

        repositorioUsuario.save(usuario);
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
    }
}
