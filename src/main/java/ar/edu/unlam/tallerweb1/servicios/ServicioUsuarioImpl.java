package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{
    private final static String UPLOADS_FOLDER = "src//main//webapp//images//logo";

    private RepositorioUsuario servicioUsuario;
    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
    }
    @Override
    public Usuario buscarUsuarioPorCodigo(String codigo) {
        return servicioUsuario.buscarUsuarioPorCodigo(codigo);
    }

    @Override
    public void save(Usuario usuario) {
        servicioUsuario.save(usuario);
    }

    @Override
    public void update(Usuario usuario) { servicioUsuario.update(usuario);

    }

    @Override
    public Resource load(String file) throws MalformedURLException {
        Path pathFoto = getPath(file);

        Resource recurso =  new UrlResource(pathFoto.toUri());

        if (!recurso.exists() || !recurso.isReadable()) {
            throw new RuntimeException("Error: no se puede cargar la imagen: " + pathFoto.toString());
        }
        return recurso;
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        Path rootPath = getPath(uniqueFilename);
        String extension[];
        extension=file.getOriginalFilename().split("\\.");

        if(extension[1].equals("jpg")||extension[1].equals("png")||extension[1].equals("svg")||extension[1].equals("jpeg")) {

            Files.copy(file.getInputStream(), rootPath);

            return uniqueFilename;

        }else{
            return null;
        }
    }

    @Override
    public boolean delete(String file) {
        Path rootPath = getPath(file);
        File archivo = rootPath.toFile();

        if (archivo.exists() && archivo.canRead()) {
            if (archivo.delete()) {
                return true;
            }
        }
        return false;
    }
    public Path getPath(String file) {
        return Paths.get(UPLOADS_FOLDER).resolve(file).toAbsolutePath();
    }

}
