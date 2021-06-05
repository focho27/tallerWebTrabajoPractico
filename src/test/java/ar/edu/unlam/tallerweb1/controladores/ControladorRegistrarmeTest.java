package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;




import static org.assertj.core.api.Assertions.*;


public class ControladorRegistrarmeTest extends SpringTest {
    private final Usuario USUARIO = usuario("H12B09","prueba@gmail.com", "123123");

    private ModelAndView mav;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private ControladorRegistro controladorRegistro ;



    /*
     * 1. registro con exito   =)
     * 2. registro erroneo por usuario ya existente    =)
     *         agregar validacion mensaje de error     =)
     * 3. registro erroneo por mail invalido TODO
     * 4. registro erroneo por clave invalida TODO
     * 5. registro erroneo por clave no coincide    =)
     *        encapsular los datos de registro en un objeto TODO
     * */

    @Test
    @Transactional
    @Rollback
    public void siElUsuarioNoExisteDeberiaPoderRegistrarse(){
        givenUsuarioNoRegistrado(USUARIO);

        whenRegistroElUsuario(USUARIO);

        thenElUsuarioSeRegistraConExito();
    }

    @Test
    @Transactional
    @Rollback
    public void siElUsuarioYaExisteNoDeberiaPoderRegistrarse(){


        givenUsuarioRegistrado(USUARIO);


        whenRegistroElUsuario(USUARIO);

        thenRegistraFallaPor("usuario ya existe");
    }
    @Test
    @Transactional
    @Rollback
    public void queSePuedaCambiarLaContrasena(){


        givenUsuarioRegistrado(USUARIO);


        whenCambioContrasenaDelUsuario(USUARIO);

        thenVeoUsuarioConLaContrasenaNueva();
    }

    private void thenVeoUsuarioConLaContrasenaNueva() {
        assertThat(USUARIO.getPassword()).isEqualTo("hola123");
    }

    private void whenCambioContrasenaDelUsuario(Usuario usuario) {
        usuario.setPassword("hola123");
        controladorRegistro.recuperarContrasenaDos(usuario);
    }


    private void whenRegistroElUsuario(Usuario USUARIO) {


        mav = controladorRegistro.guardarUsuario(USUARIO);

    }

    private void givenUsuarioRegistrado(Usuario usuario) {
        //controladorRegistro.guardarUsuario(USUARIO,request);
        mav = controladorRegistro.guardarUsuario(USUARIO);


    }

    private void givenUsuarioNoRegistrado(Usuario usuario) {

    }

    private void thenElUsuarioSeRegistraConExito() {
       // assertThat(mav.getModel().get("Usuario")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getViewName()).isEqualTo("redirect:/login");
    }

    private void thenRegistraFallaPor(String motivo) {
        //assertThat(mav.getModel().get("usuario")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);
        assertThat(mav.getViewName()).isEqualTo("usuarioForm");
    }

    private Usuario usuario(String matricula,String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(matricula);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }
}