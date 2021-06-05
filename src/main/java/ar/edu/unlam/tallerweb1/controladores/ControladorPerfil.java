package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPost;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ControladorPerfil {
    private ServicioUsuario servicioUsuario;
    private ServicioPost servicioPost;

    @Autowired
    public ControladorPerfil(ServicioUsuario servicioUsuario,ServicioPost servicioPost){
        this.servicioUsuario = servicioUsuario;
        this.servicioPost=servicioPost;
    }

    @RequestMapping(path = "/usuario/{codigo}")
    public ModelAndView verPerfilUsuario(@PathVariable("codigo") String codigo)  {

        ModelMap modelo = new ModelMap();
        Usuario usuario =servicioUsuario.buscarUsuarioPorCodigo(codigo);
        List<Post> posteos=((List<Post>)servicioPost.findAllByMatricula(codigo));
        modelo.put("usuario",usuario);
        modelo.put("posts",posteos);
        return new ModelAndView("perfilUsuario", modelo);
    }
}
