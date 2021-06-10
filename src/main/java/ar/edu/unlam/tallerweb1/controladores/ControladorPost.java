package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.servicios.ServicioPost;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Controller
@SessionAttributes("post")
public class ControladorPost {

    private static ServicioPost servicioPost;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorPost(ServicioPost servicioPost,ServicioUsuario servicioUsuario) {
        this.servicioPost = servicioPost;
        this.servicioUsuario=servicioUsuario;
    }


    public static ServicioPost getServicioPost() {
        return servicioPost;
    }

    public void setServicioPost(ServicioPost servicioPost) {
        this.servicioPost = servicioPost;
    }

  /*  @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
*/
  @RequestMapping(value = "/images/{filename:.+}")
  public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

      Resource recurso = null;
      try {
          recurso = servicioPost.load(filename);
      } catch (MalformedURLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
              .body(recurso);

  }
    @RequestMapping(value = "/posts/filtro/images/{filename:.+}")
    public ResponseEntity<Resource> verImagenesPorFiltro(@PathVariable String filename) {

        Resource recurso = null;
        try {
            recurso = servicioPost.load(filename);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);

    }
    @RequestMapping(path="/posts")
    public ModelAndView viewPosts() {

        ModelMap modelo = new ModelMap();

        List<Post> posts = servicioPost.findAll();
        modelo.put("posts", posts);

        return new ModelAndView("postsHome", modelo);
    }
    @RequestMapping(path="/create/post")
    public ModelAndView createPost() {

        ModelMap modelo = new ModelMap();

       Post post = new Post();
        modelo.put("post", post);

        return new ModelAndView("postsForm", modelo);
    }
    @RequestMapping(path="/create/post",method = RequestMethod.POST)
    public ModelAndView guardarPost(@ModelAttribute("post") Post post, @RequestParam("file") MultipartFile file, SessionStatus sessionStatus) throws MalformedURLException {
        ModelMap modelo = new ModelMap();

        if(file!=null && file.getOriginalFilename()!=null && file.getOriginalFilename().length()>0) {
            if(post.getId() != null && post.getImagen() != null ){
                servicioPost.delete(post.getImagen());
            }
            String uniqueFilename = null;
            try {
                uniqueFilename = servicioPost.copy(file);
            } catch (IOException e) {

                e.printStackTrace();
            }

            post.setImagen(uniqueFilename);
        }
        if (post != null &&  servicioUsuario.buscarUsuarioPorCodigo(post.getMatricula())!=null) {
            if(((servicioPost.postFindByEspecialidad(post.getEspecialidad(),servicioUsuario.buscarUsuarioPorCodigo(post.getMatricula()).getCodigo()))==false) && (post.getId()==null)){
                if(file!=null&& file.getOriginalFilename().length()>0){
                servicioPost.save(post);
                sessionStatus.setComplete();
                return new ModelAndView("redirect:/posts");}else{
                    modelo.put("error", "No se puede porque falta que cargue la imagen");

                    return new ModelAndView("postsForm", modelo);

                }
            }else if((post.getId()!=null )){
                if((servicioPost.postFindById(post.getId()).getEspecialidad().equals(post.getEspecialidad())) && ((servicioPost.postFindByEspecialidad(post.getEspecialidad(),servicioUsuario.buscarUsuarioPorCodigo(post.getMatricula()).getCodigo()))==true)){
                    servicioPost.update(post);
                    sessionStatus.setComplete();
                    return new ModelAndView("redirect:/posts");
                }else if((!(servicioPost.postFindById(post.getId()).getEspecialidad().equals(post.getEspecialidad()))) &&  ((servicioPost.postFindByEspecialidad(post.getEspecialidad(),servicioUsuario.buscarUsuarioPorCodigo(post.getMatricula()).getCodigo()))==false)){
                    servicioPost.update(post);
                    sessionStatus.setComplete();
                    return new ModelAndView("redirect:/posts");
                }else {
                    modelo.put("error", "No se puede porque ya hay un post con esta especialidad y matricula igual a : "+         servicioPost.postFindByEspecialidad(post.getEspecialidad(),post.getMatricula()));

                }
            }else {
                modelo.put("error", "No se puede porque ya hay un post con esta especialidad y matricula igual a : "+         servicioPost.postFindByEspecialidad(post.getEspecialidad(),post.getMatricula()));
            }
        } else if( servicioUsuario.buscarUsuarioPorCodigo(post.getMatricula())==null){
            // si el usuario no existe agrega un mensaje de error en el modelo.
            modelo.put("error", "No se puede porque no existe el usaurio con esa matricula");
        }else{
            modelo.put("error", "No hay post para guardar");

        }



        return new ModelAndView("postsForm", modelo);
    }
    @RequestMapping(path="/post/form/{id}")
    public ModelAndView editPost(@PathVariable("id")Long id) {

        ModelMap modelo = new ModelMap();

        Post post =servicioPost.postFindById(id);;
        modelo.put("post", post);

        return new ModelAndView("postsForm", modelo);
    }
    @RequestMapping(path="/post/{id}")
    public ModelAndView viewPostById(@PathVariable("id")Long id) {

        ModelMap modelo = new ModelMap();

        Post post =    servicioPost.postFindById(id);;
        modelo.put("post", post);

        return new ModelAndView("postsDetail", modelo);
    }
    @RequestMapping(path="/post/delete/{id}")
    public ModelAndView deletePost(@PathVariable("id")Long id) {



        Post post =    servicioPost.postFindById(id);
        if(post.getImagen()!=null){
        servicioPost.delete(post.getImagen());
        }
        servicioPost.delete(post);


        return new ModelAndView("redirect:/posts");
    }
    @RequestMapping(path="/posts/filtro/especialidad")
    public ModelAndView filtrarPorEspecialidad(@RequestParam(value="especialidad",required = true)String especialidad) {
        System.out.println(especialidad);
        ModelMap modelo = new ModelMap();
        if(especialidad.equals("all")){
            return new ModelAndView("redirect:/posts");
        }
        List<Post> posts= servicioPost.postFindByEspecialidad(especialidad);
        System.out.println(posts);
        if(posts!=null && posts.size()>=1) {
            modelo.put("posts", posts);
            return new ModelAndView("postsHome", modelo);
        }else {
            return new ModelAndView("redirect:/posts");
        }
    }
}
