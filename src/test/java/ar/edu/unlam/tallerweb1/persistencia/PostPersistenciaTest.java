package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Post;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.*;
public class PostPersistenciaTest extends SpringTest {


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
}



