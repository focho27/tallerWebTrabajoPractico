package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface ServicioUsuario {
    Usuario buscarUsuarioPorCodigo(String matricula);
    void save(Usuario usuario);
    void update(Usuario usuario);
    public Resource load(String filename) throws MalformedURLException;

    public String copy(MultipartFile file) throws IOException;

    public boolean delete(String filename);
}
