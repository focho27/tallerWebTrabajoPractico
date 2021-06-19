package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;

import java.util.List;

public interface RepositorioPuntuacion {

    void update(Puntaje puntaje);

    Puntaje buscarPuntajePorMatriculaEspecialidad(String matricula, String especialidad);

    void save(Puntaje puntaje);

    List<Puntaje> findAll();
}
