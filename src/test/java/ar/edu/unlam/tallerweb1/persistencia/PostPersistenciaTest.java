package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPost;
import ar.edu.unlam.tallerweb1.servicios.ServicioPost;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
public class PostPersistenciaTest extends SpringTest {

    private final Usuario USUARIO = usuario("H12B09","prueba@gmail.com", "123123");
    private final Post POST = post("H12B09","Riki Fort");
    private final String MATRICULA= USUARIO.getCodigo();
    @Autowired
    private RepositorioPost repositorioPost;
    @Autowired
    private ServicioPost servicioPost;
    @Test @Transactional
    @Rollback
    public void queNoSePuedaGuardarPosteoPorEspecialidadYMatriculaYaExistente(){
        givenPostGuardadoConMatricula(POST);
        whenIntentoGuardarPostConMismaMatriculaYEspecialidad(POST);
        thenHaySoloUnPostGuardado();
    }

    private void thenHaySoloUnPostGuardado() {
        Integer contador = 0;
    for (int i=0;i<servicioPost.findAll().size();i++){
        if(servicioPost.findAll().get(i).getEspecialidad()==null){
            contador++;
        }
    }
        assertThat(contador).isEqualTo(1);
    }

    private void whenIntentoGuardarPostConMismaMatriculaYEspecialidad(Post post) {
        servicioPost.save(POST);
    }

    private void givenPostGuardadoConMatricula(Post POST) {
        servicioPost.save(POST);
    }

    @Test @Transactional @Rollback
        public void poderGuardarUnPosteo(){
            Post nuevo = givenExisteUnPosteo();
            Long id = whenGuardoElPosteo(nuevo);
            thenLoPuedoBuscarPorSuId(id);
        }

        @Test @Transactional @Rollback
        public void borrarUnPosteo(){
        Post nuevo = givenExisteUnPosteo();
        Long id = whenGuardoElPosteo(nuevo);
        Post nuevo2= givenExisteUnPosteo();
        Long id2 = whenGuardoElPosteo(nuevo2);
        thenLoPuedoBuscarPorSuId(id);
        borrarPosteo(nuevo);
        }


        private Post givenExisteUnPosteo() {
            Post nuevo = new Post();
            nuevo.setNombre("nuevo posteo");
            return nuevo;
        }

        private Long whenGuardoElPosteo(Post nuevo) {
            session().save(nuevo);
            return nuevo.getId();
        }

        private void thenLoPuedoBuscarPorSuId(Long id) {
            Post buscado = session().get(Post.class, id);
            assertThat(buscado).isNotNull();
        }

        private void borrarPosteo(Post aBorrar){
            session().delete(aBorrar);
        }
    public Post post(String matricula, String nombre){
        Post post = new Post();
        post.setMatricula(matricula);
        post.setNombre(nombre);
        return post;
    }
    private Usuario usuario(String matricula,String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(matricula);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }
}



