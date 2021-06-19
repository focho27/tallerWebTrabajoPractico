package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioContratado;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPost;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ControladorContratar {

    private ServicioContratado servicioContratado;
    private ServicioUsuario servicioUsuario;
    private ServicioPost servicioPost;
    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorContratar(ServicioUsuario servicioUsuario, ServicioContratado servicioContratado, ServicioPost servicioPost, ServicioLogin servicioLogin) {
        this.servicioUsuario=servicioUsuario;
        this.servicioContratado= servicioContratado;
        this.servicioPost=servicioPost;
        this.servicioLogin = servicioLogin;
    }

    @RequestMapping(path="/contratar/{id}",method = RequestMethod.GET)
    public ModelAndView contratar(@PathVariable("id") Long id) {
            ModelMap modelo = new ModelMap();
            String usuarioConectado = servicioLogin.obtenerConectado();
            Post post = servicioPost.postFindById(id);
            servicioContratado.asignarParametros(post, usuarioConectado);
            Usuario usuario =servicioUsuario.buscarUsuarioPorCodigo(post.getMatricula());
            modelo.put("usuario",usuario);
            return new ModelAndView("detalleContratacion", modelo);
    }
    @RequestMapping(path="/contratar/mensaje",method = RequestMethod.GET)
    public ModelAndView mensajeContratacion(@RequestParam("mensaje") String mensaje,@RequestParam("nombre") String nombre) {
        ModelMap modelo = new ModelMap();
        //Usuario usuario =servicioUsuario.buscarUsuarioPorMatricula(matricula);
        modelo.put("mensaje",mensaje);
        modelo.put("nombre",nombre);
        return new ModelAndView("mensajeContratacion", modelo);
    }
    @RequestMapping(path="/contratados",method = RequestMethod.GET)
    public ModelAndView viewContratados() {
        ModelMap modelo = new ModelMap();
        String usuarioConectado = servicioLogin.obtenerConectado();
        System.out.println(usuarioConectado);
        List<Contratado> contratados = servicioContratado.findbyCodContratante(usuarioConectado);

        modelo.put("contratados", contratados);
        return new ModelAndView("contratados", modelo);
    }

    @RequestMapping(path="/cancelacion/{id}",method = RequestMethod.GET)
    public ModelAndView cancelarServicio(@PathVariable("id") Long id) {
        Contratado contratado = servicioContratado.postFindById(id);
        servicioContratado.delete(contratado);
        return new ModelAndView("redirect:/contratados");
    }
}
