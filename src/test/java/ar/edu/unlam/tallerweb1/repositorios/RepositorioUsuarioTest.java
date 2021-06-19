package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

public class RepositorioUsuarioTest extends SpringTest {
    private final Usuario USUARIO = usuario("H12B09","prueba@gmail.com", "123123");

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public RepositorioUsuarioTest() {

    }

    @Test
    @Transactional
    @Rollback
    public void poderGuardarUsuario(){
        givenUsuarioValido();
        whenGuardoUsuario(USUARIO);
        thenLoPuedoBuscarPorId(USUARIO.getCodigo());
    }

    private void thenLoPuedoBuscarPorId(String codigo) {
        assertThat(repositorioUsuario.buscarUsuarioPorCodigo(codigo)).isEqualTo(USUARIO);
    }

    private void whenGuardoUsuario(Usuario usuario) {
        repositorioUsuario.save(usuario);
    }

    private void givenUsuarioValido() {

    }
    @Test
    @Transactional
    @Rollback
    public void buscarUsuarioQUeNoExisteNoDevuelveUnUsuario(){
        givenUsuarioValido();
        whenNoGuardoUsuario();
        thenNoEncuentraUsuario("asd123asdasd");
    }

    private void thenNoEncuentraUsuario(String codigo) {
        assertThat(repositorioUsuario.buscarUsuarioPorCodigo(codigo)).isNull();
    }

    private void whenNoGuardoUsuario() {


    }
    @Test
    @Transactional
    @Rollback
    public void queSePuedaActualizarUsuario(){
        givenUsuarioGuardado();
        whenActualizoUsuario("sasa@gmail.com");
        thenVeoUsuarioActualizado(USUARIO.getCodigo());
    }

    private void thenVeoUsuarioActualizado(String codigo) {
        assertThat(repositorioUsuario.buscarUsuarioPorCodigo(codigo).getEmail()).isEqualTo("sasa@gmail.com");
    }

    private void whenActualizoUsuario(String s) {
        USUARIO.setEmail(s);
        repositorioUsuario.update(USUARIO);
    }

    private void givenUsuarioGuardado() {
        repositorioUsuario.save(USUARIO);
    }


    private Usuario usuario(String matricula,String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(matricula);
        usuario.setEmail(email);
        usuario.setPassword(clave);
        return usuario;
    }

}