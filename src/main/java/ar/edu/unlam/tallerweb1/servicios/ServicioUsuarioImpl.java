package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{

    private RepositorioUsuario servicioUsuario;
    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
    }
    @Override
    public Usuario buscarUsuarioPorMatricula(String matricula) {
        return servicioUsuario.buscarUsuarioPorMatricula(matricula);
    }

    @Override
    public void save(Usuario usuario) {
        servicioUsuario.save(usuario);
    }

    @Override
    public void update(Usuario usuario) { servicioUsuario.update(usuario);

    }
}
