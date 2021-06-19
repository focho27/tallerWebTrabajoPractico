package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPost;
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
import java.util.List;
import java.util.UUID;

@Service("servicioPost")
@Transactional
public class ServicioPostImpl implements ServicioPost{
    private final static String UPLOADS_FOLDER = "C://Users//Alexis//IdeaProjects//TW-nos//src//main//webapp//images";
    private String uniqueFile="";
    private RepositorioPost postDao;
    @Autowired
    public ServicioPostImpl(RepositorioPost postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> findAll() {

        return postDao.findAll()!=null?postDao.findAll():null;
    }

    @Override
    public Post postFindById(Long id) {
        return postDao.postFindById(id);
    }

    @Override
    public void save(Post post) {
        if(post!=null)
        if((postDao.postFindByEspecialidadAndMatricula(post.getEspecialidad(),post.getMatricula()))==false)
            postDao.save(post);

    }

    @Override
    public void delete(Post post) {
    postDao.delete(post);
    }

    @Override
    public List<Post> findAllByMatricula(String matricula){
        return postDao.findAllByMatricula(matricula);
    }

    @Override
    public Boolean postFindByEspecialidad(String especialidad,String matricula) {
        return postDao.postFindByEspecialidadAndMatricula(especialidad,matricula);
    }

    @Override
    public void update(Post post) {
    postDao.update(post);
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
        String resourcePath = getPath("").toUri().toString();
        System.out.println(getPath(""));
        System.out.println("este es el resource path: " + resourcePath);
        System.out.println("INput stream  "+file.getInputStream());
        System.out.println("Root  "+rootPath);
        System.out.println("Extension " + extension);
        System.out.println("File: " + file);
        if(extension[1].equals("jpg")||extension[1].equals("png")||extension[1].equals("svg")||extension[1].equals("jfif")||extension[1].equals("jpeg")) {

            Files.copy(file.getInputStream(), rootPath);
            setUniqueFileName(uniqueFilename);
            return uniqueFilename;

        }else{
            return null;
        }
    }
    public void setUniqueFileName(String uniqueFileName){
           this.uniqueFile=uniqueFileName;

    }
    @Override
    public String getUniqueFileName(){
        return this.uniqueFile;
    }

    @Override
    public List<Post> postFindByEspecialidad(String especialidad) {
        return postDao.postFindByEspecialidad(especialidad);
    }



    @Override
    public void asignarParametros(Contratado contratado) {
        Post post = new Post();
        post.setId(contratado.getId());
        post.setNombre(contratado.getNombre());
        post.setDescripcion(contratado.getDescripcion());
        post.setMatricula(contratado.getMatricula());
        post.setEspecialidad(contratado.getEspecialidad());
        post.setFecha(contratado.getFecha());
        post.setImagen(contratado.getImagen());
        post.setZona(contratado.getZona());
        postDao.save(post);
    }

    @Override
    public void agregarAFavorito(Long postId, String usuarioConectado) {
            Favorito favorito = new Favorito();
            favorito.setCodUsuario(usuarioConectado);
            favorito.setPostFav(postId);
            postDao.guardarFavorito(favorito);
        }

    public Boolean buscarUsuarioYPostEnFavorito(Long postId, String usuarioConectado){
        return postDao.buscarUsuarioYPostEnFavorito(postId, usuarioConectado);

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
