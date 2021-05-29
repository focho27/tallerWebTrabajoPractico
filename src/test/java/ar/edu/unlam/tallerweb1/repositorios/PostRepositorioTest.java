package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Post;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class PostRepositorioTest  extends SpringTest{


    @Autowired
    private RepositorioPost repositorio;

    public PostRepositorioTest( ) {

    }


    @Test
    @Transactional
    @Rollback
    public void guardarUnPosteoDeberiaPersistir() {
        Post nuevo = new Post();

        nuevo.setNombre("Trabajo realizado Ayer");
        repositorio.save(nuevo);

        Post buscado = repositorio.postFindById(nuevo.getId());
        assertThat(buscado).isNotNull();
    }


    @Test @Transactional @Rollback
    public void buscarPorNombre() {
        Post nuevo = new Post();
        nuevo.setNombre("Trabajo realizado Ayer");
        repositorio.save(nuevo);

        Post ultimo = new Post();
        ultimo.setNombre("Trabajo realizado Hoy");
        repositorio.save(ultimo);

        //List<Post> buscadas = (List<Post>) repositorio.(ultimo.getNombre());
        //assertThat(buscadas).hasSize(1);
    }




    @Test
    @Transactional
    @Rollback
    public void buscarPorId() {
        Post nuevo = new Post();

        repositorio.save(nuevo);

        Post nuevo2 = new Post();

        repositorio.save(nuevo2);

        List<Post> buscadas = new ArrayList<>();
        buscadas.add( repositorio.postFindById(nuevo2.getId()));
        assertThat(buscadas).hasSize(1);
    }



    @Test @Transactional @Rollback
    public void borrarPost() {
        Post nuevo = new Post();
        repositorio.save(nuevo);
        Post nuevo2 = new Post();
        repositorio.save(nuevo2);
        Post nuevo3 = new Post();
        repositorio.save(nuevo3);


        repositorio.delete(nuevo);
        assertThat( repositorio.findAll()).hasSize(2);
    }



}