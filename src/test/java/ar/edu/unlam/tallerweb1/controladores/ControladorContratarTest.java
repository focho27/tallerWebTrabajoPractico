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
import org.springframework.web.servlet.ModelAndView;


import static org.assertj.core.api.Assertions.assertThat;

public class ControladorContratarTest extends SpringTest {
    private final Usuario USUARIO = usuario("H12B09","prueba@gmail.com", "123123");
    private final Post POST = post(1l,"H12B09","Riki Fort");



    private final String MATRICULA= USUARIO.getCodigo();
    private final String MENSAJE="El mas grande";
    private final String NOMBRE="Ruben";
    @Autowired
    private RepositorioPost repositorioPost;
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private ControladorContratar controladorContratar ;
    private ModelAndView mav;


    @Test
    @Transactional
    @Rollback
    public void queSePuedaContratar()  {
        giveUsuarioConMatriculaValida(USUARIO);
        whenContratoUnServicio();
        thenVeoDetalleContratacion("usuario");
    }
    @Test
    @Transactional
    @Rollback
    public void queSeEnvieMensajePostContratado()  {
        giveUsuarioConMatriculaValida(USUARIO);
        whenContratoUnServicioYEnvioMensaje();
        thenVeoDetalleContratacionConMensaje("mensaje","nombre");
    }

    private void thenVeoDetalleContratacionConMensaje(String mensaje, String nombre) {
        assertThat(mav.getModel().get(mensaje)).isEqualTo(MENSAJE);
        assertThat(mav.getModel().get(nombre)).isEqualTo(NOMBRE);
        assertThat(mav.getViewName()).isEqualTo("mensajeContratacion");
    }

    private void whenContratoUnServicioYEnvioMensaje() {
        controladorContratar.contratar(POST.getId());
        mav= controladorContratar.mensajeContratacion(MENSAJE,NOMBRE);
    }

    private void thenVeoDetalleContratacion(String usuario) {
        assertThat(mav.getModel().get(usuario)).isEqualTo(USUARIO);
        assertThat(mav.getViewName()).isEqualTo("detalleContratacion");
    }

    private void whenContratoUnServicio() {
        mav=controladorContratar.contratar(POST.getId());

    }
    private void giveUsuarioConMatriculaValida(Usuario usuario) {
        repositorioUsuario.save(usuario);
        repositorioPost.save(POST);
    }


    private Usuario usuario(String matricula,String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(matricula);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }
    private Post post(Long id,String matricula, String nombre) {
        Post post = new Post();
        post.setId(id);
        post.setMatricula(matricula);
        post.setNombre(nombre);
        return post;
    }
}
