package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.repositorios.PostRepositorioTest;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPost;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PostServiceTest extends SpringTest {

    @Mock
    RepositorioPost postRepositorio;

    @Autowired
    ServicioPost servicioPost;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Transactional
    @Rollback
    public void traerListaPost(){
        Post post=  givenListaPost();
        whenEjecutoMetodoFindAll(post);
        thenComparoSizeDeLaLista(1,post);
    }

    private void thenComparoSizeDeLaLista(Integer num,Post post) {
       
        assertThat(this.postRepositorio.findAll().size()).isEqualTo(num);

    }

    private void whenEjecutoMetodoFindAll(Post post) {
        Mockito.when(this.postRepositorio.findAll()).thenReturn(Stream.of(post).collect(Collectors.toList()));

    }

    private Post givenListaPost() {
        Post post = new Post();
        return post;
    }
}
