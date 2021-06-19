package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntuacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPuntuacion")
@Transactional
public class ServicioPuntuacionImpl implements ServicioPuntuacion{

    private RepositorioPuntuacion repositorioPuntuacion;

    @Autowired ServicioPuntuacionImpl(RepositorioPuntuacion repositorioPuntuacion){
        this.repositorioPuntuacion = repositorioPuntuacion;
    }

    public void recibirVoto(Long puntaje, String matricula, String especialidad){

        Puntaje puntuacion =  repositorioPuntuacion.buscarPuntajePorMatriculaEspecialidad(matricula, especialidad);
        puntuacion.setNum_votes(puntuacion.getNum_votes() + 1L);
        puntuacion.setTotal_score(puntuacion.getTotal_score()+puntaje);
        puntuacion.setRating(puntuacion.getTotal_score()/ puntuacion.getNum_votes());
        repositorioPuntuacion.update(puntuacion);

    }

    public void save(String matricula, String especialidad){
        if(buscarPuntajePorMatriculaEspecialidad(matricula, especialidad)!=null){

        }
        else{
            Puntaje puntaje = new Puntaje();
            puntaje.setMatriculaEspecialidad(matricula+especialidad);
            repositorioPuntuacion.save(puntaje);
        }
    }

    @Override
    @Transactional
    public Puntaje buscarPuntajePorMatriculaEspecialidad(String matricula, String especialidad) {
        return repositorioPuntuacion.buscarPuntajePorMatriculaEspecialidad(matricula, especialidad); }

    @Override
    public List<Puntaje> findAll() {

        return repositorioPuntuacion.findAll()!=null?repositorioPuntuacion.findAll():null;
    }
}
