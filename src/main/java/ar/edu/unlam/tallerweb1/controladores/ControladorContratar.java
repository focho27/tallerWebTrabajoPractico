package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class ControladorContratar {

    private ServicioUsuario servicioUsuario;
    @Autowired
    public ControladorContratar(ServicioUsuario servicioUsuario) {
        this.servicioUsuario=servicioUsuario;
    }

    @RequestMapping(path="/contratar/{matricula}",method = RequestMethod.GET)
    public ModelAndView viewPostById(@PathVariable("matricula") String matricula) {

        ModelMap modelo = new ModelMap();
        Usuario usuario =servicioUsuario.buscarUsuarioPorMatricula(matricula);
        modelo.put("usuario",usuario);
        return new ModelAndView("detalleContratacion", modelo);
    }
    @RequestMapping(path="/contratar/mensaje",method = RequestMethod.GET)
    public ModelAndView viewPostById(@RequestParam("mensaje") String mensaje,@RequestParam("nombre") String nombre) {
        ModelMap modelo = new ModelMap();
        //Usuario usuario =servicioUsuario.buscarUsuarioPorMatricula(matricula);
        modelo.put("mensaje",mensaje);
        modelo.put("nombre",nombre);
        return new ModelAndView("mensajeContratacion", modelo);
    }
}
