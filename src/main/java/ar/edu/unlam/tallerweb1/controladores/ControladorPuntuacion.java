package ar.edu.unlam.tallerweb1.controladores;

        import ar.edu.unlam.tallerweb1.modelo.Puntaje;
        import ar.edu.unlam.tallerweb1.servicios.ServicioPuntuacion;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPuntuacion {

    private ServicioPuntuacion servicioPuntuacion;

    @Autowired
    public ControladorPuntuacion(ServicioPuntuacion servicioPuntuacion) {
        this.servicioPuntuacion = servicioPuntuacion;
    }

    @RequestMapping(path = "/puntuar", method = RequestMethod.GET)
    public ModelAndView puntuar(@RequestParam("matricula") String matricula, @RequestParam ("puntaje") Long puntaje, @RequestParam ("especialidad") String especialidad){
        servicioPuntuacion.recibirVoto(puntaje, matricula, especialidad);
        return new ModelAndView("redirect:/posts");

    }


}
