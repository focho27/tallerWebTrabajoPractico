package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ControladorRegistro {

    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorRegistro(ServicioUsuario servicioUsuario) {

        this.servicioUsuario=servicioUsuario;
    }


    @RequestMapping(path="/crear-usuario")
    public ModelAndView crearUsuario() {

        ModelMap modelo = new ModelMap();
        // Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
        // al model attribute del form que esta definido en la vista 'login'
        Usuario usuario = new Usuario();
        modelo.put("usuario", usuario);
        // Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
        // y se envian los datos a la misma  dentro del modelo
        return new ModelAndView("usuarioForm", modelo);
    }
    @RequestMapping(path="/crear-usuario",method = RequestMethod.POST)
    public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        ModelMap modelo = new ModelMap();
        // Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
        // al model attribute del form que esta definido en la vista 'login'
       Usuario user= servicioUsuario.buscarUsuarioPorMatricula(usuario.getMatricula());
        if (usuario != null && servicioUsuario.buscarUsuarioPorMatricula(usuario.getMatricula())==null) {

            servicioUsuario.save(usuario);
            return new ModelAndView("redirect:/login");
        }else {
            modelo.put("error","usuario ya existe");
            return new ModelAndView("usuarioForm",modelo);
        }


    }
    @RequestMapping(path = "/recuperar-contrasena", method = RequestMethod.POST)
    public ModelAndView recuperarContrasenaDos(@ModelAttribute("usuario") Usuario usuario) {
        System.out.println(usuario.getPassword());
        System.out.println(usuario.getMatricula());

        servicioUsuario.update(usuario);

        return new ModelAndView("redirect:/login");
    }
    @RequestMapping(path = "/recuperar-contrasena/buscador")
    public ModelAndView recuperarContrasena(@RequestParam(name="matricula",required = false) String matricula) {
        ModelMap modelo = new ModelMap();
        Usuario usuario =servicioUsuario.buscarUsuarioPorMatricula(matricula);
        System.out.println(usuario.getMatricula());
        System.out.println(usuario.getEmail());
        System.out.println(matricula);
        modelo.put("usuario",usuario);
        return new ModelAndView("recuperarContrasena2", modelo);
    }

    @RequestMapping(path = "/recuperar-contrasena")
    public ModelAndView recuperarContrasena2() {
        ModelMap modelo = new ModelMap();
        Usuario usuario = new Usuario();
        modelo.put("usuario", usuario);
        return new ModelAndView("recuperarContrasena1", modelo);
    }
}
