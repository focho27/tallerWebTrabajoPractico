package ar.edu.unlam.tallerweb1.repositorios;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
public class TestRepositorioContratado extends SpringTest {

    private final Usuario CAMILA = usuario("11111", "prueba1@gmail.com", "123123");
    private final Usuario LUCIANO = usuario("22222", "prueba2@gmail.com", "123123");
    private final Usuario PABLO = usuario("00000", "prueba3@gmail.com", "123123");
    private final Contratado CONTRATADO1 = contratado("11111", "limpieza", "00000", 1L);
    private final Contratado CONTRATADO2 = contratado("22222", "niniera", "00000", 2L);
    private final Contratado CONTRATADO3 = contratado("11111", "plomeria", "00000", 3L);
    @Autowired
    private RepositorioContratado repositorioContratado;
  /*  @Test
    @Transactional
    @Rollback
    public void mostrarPostsContratadosMeTraeLosContratadosPorElUsuarioConsultado() {

        givenUsuarioRegistrado(CAMILA);
        givenUsuarioRegistrado(LUCIANO);
        givenPostContratado(CONTRATADO1);
        givenPostContratado(CONTRATADO2);
        givenPostContratado(CONTRATADO3);
        List<Contratado> contratados = whenBuscoPostsContratadosDe(CAMILA);
        thenMeMuestra(contratados, 2);
    }*/

    @Test
    @Transactional
    @Rollback
    public void alContratarUnPostElMismoSeGuarda( ){

        givenListaVacia();
        givenPostContratado(CONTRATADO1);
        whenBuscoContratado(CONTRATADO1);
        thenEncuentroElPostGuardadoEnLaLista();
    }

    @Test
    @Transactional
    @Rollback
    public void alCancelarUnServicioContratadoElMismoSeBorra(){

        givenListaVacia();
        givenPostContratado(CONTRATADO1);
        givenListaContratados();
        whenCanceloContratado(CONTRATADO1);
        thenSeEliminaElPostContratadoDeLaLista();
    }



    private void givenListaContratados() {
        assertThat(repositorioContratado).isNotNull();
    }

    private void thenSeEliminaElPostContratadoDeLaLista() {
        assertThat(repositorioContratado.findAll()).isEmpty();
    }

    private void whenCanceloContratado(Contratado contratado1) {
        repositorioContratado.delete(contratado1);
    }

    private void givenListaVacia() {
        assertThat(repositorioContratado.findAll()).isEmpty();
    }

    private void thenEncuentroElPostGuardadoEnLaLista() {
        assertThat(repositorioContratado.findAll()).isNotNull();
        assertThat(repositorioContratado.findAll()).hasSize(1);
        assertThat(repositorioContratado.postFindById(CONTRATADO1.getId())).isEqualTo(CONTRATADO1);
    }

    private void whenBuscoContratado(Contratado contratado1) {
        repositorioContratado.postFindById(contratado1.getId());
    }

    private void givenUsuarioRegistrado(Usuario usuario) {
        session().save(usuario); }

    private void givenPostContratado(Contratado contratado) {
        session().save(contratado); }

   /* private List<Contratado> whenBuscoPostsContratadosDe(Usuario camila) {
        return repositorioContratado.findByCodContrantante(camila.getCodigo());
    }*/

    private void thenMeMuestra(List<Contratado> contratados, Integer cantidadEsperada) {
        assertThat(contratados).hasSize(cantidadEsperada);
    }

    private Usuario usuario(String codUsuario, String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(codUsuario);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }

    private Post post(String titulo, String especialidad, String codUsuarioQuePublica){
        Post post = new Post();
        post.setNombre(titulo);
        post.setEspecialidad(especialidad);
        post.setMatricula(codUsuarioQuePublica);
        return post;
    }

    private Contratado contratado(String codContratante, String especialidad, String codUsuarioQuePublica, Long id){
        Contratado contratado = new Contratado();
       /* contratado.setCodContratante(codContratante);*/
        contratado.setMatricula(codUsuarioQuePublica);
        contratado.setEspecialidad(especialidad);
        contratado.setId(id);
        return contratado;
    }


}