package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioContratado;
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
    @Autowired
    public ControladorContratar(ServicioUsuario servicioUsuario,ServicioContratado servicioContratado,ServicioPost servicioPost) {
        this.servicioUsuario=servicioUsuario;
        this.servicioContratado= servicioContratado;
        this.servicioPost=servicioPost;
    }

    @RequestMapping(path="/contratar/{id}",method = RequestMethod.GET)
    public ModelAndView contratar(@PathVariable("id") Long id) {
        ModelMap modelo = new ModelMap();
        Post post = servicioPost.postFindById(id);
        servicioContratado.asignarParametros(post);
        servicioPost.delete(post);
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
        List<Contratado> contratados = servicioContratado.findAll();
        modelo.put("contratados", contratados);
        return new ModelAndView("contratados", modelo);
    }

    @RequestMapping(path="/cancelacion/{id}",method = RequestMethod.GET)
    public ModelAndView cancelarServicio(@PathVariable("id") Long id) {
        Contratado contratado = servicioContratado.postFindById(id);
        servicioPost.asignarParametros(contratado);
        servicioContratado.delete(contratado);
        return new ModelAndView("redirect:/contratados");
    }
}
