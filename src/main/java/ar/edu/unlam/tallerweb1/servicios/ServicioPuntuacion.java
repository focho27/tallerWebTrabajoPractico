package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;

import java.util.List;

public interface ServicioPuntuacion {

    void recibirVoto(Long puntaje, String matricula, String especialidad);

    void save(String matricula, String especialidad);

    Puntaje buscarPuntajePorMatriculaEspecialidad(String matricula, String especialidad);

    List<Puntaje> findAll();
}
