package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.*;

public class RepositorioUsuarioTest extends SpringTest {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public RepositorioUsuarioTest() {

    }

    @Test @Transactional
    @Rollback
    public void modificarDeberiaCambiarLosDatos(){
        Usuario guardado = givenExisteUsuarioGuardado();
        guardado.setPassword("nueva");
        whenModificoElUsuario(guardado);
        thenElUsuarioSeModifica(guardado);
    }

    @Test @Transactional @Rollback
    public void buscarUsuarioQUeExisteDevuelveUnUsuario(){
        Usuario guardado = givenExisteUsuarioGuardado();
        Usuario buscado = whenBuscoElUsuario(guardado.getEmail());
        thenElUsuarioExiste(buscado);
    }

    @Test @Transactional @Rollback
    public void buscarUsuarioQUeNoExisteNoDevuelveUnUsuario(){
        Usuario guardado = givenExisteUsuarioGuardado();

        Usuario buscado = whenBuscoElUsuario(guardado.getEmail()+"kdkdkdkdkd");
        thenElUsuarioNoExiste(buscado);
    }

    private void thenElUsuarioNoExiste(Usuario buscado) {
        assertThat(buscado).isNull();
    }

    private void thenElUsuarioExiste(Usuario buscado) {
        assertThat(buscado).isNotNull();
    }

    private Usuario whenBuscoElUsuario(String email) {
        return repositorioUsuario.buscarUsuarioPorCodigo(givenExisteUsuarioGuardado().getCodigo());
    }

    private void thenElUsuarioSeModifica(Usuario guardado) {
        Usuario buscado = session().get(Usuario.class, guardado.getCodigo());
        assertThat(buscado.getPassword()).isEqualTo(guardado.getPassword());
    }

    private void whenModificoElUsuario(Usuario usuario) {
        repositorioUsuario.update(usuario);
    }

    private Usuario givenExisteUsuarioGuardado() {
        Usuario usuario = new Usuario();
        usuario.setCodigo("ASD123");
        usuario.setEmail("barat@barat.com");
        usuario.setPassword("sasa");
        session().save(usuario);
        return usuario;
    }
}