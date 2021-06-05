package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ServicioContratado {
    List<Contratado> findAll();
    Contratado postFindById(Long id);
    void save(Contratado contratado);
    void delete(Contratado contratado);
    void asignarParametros(Post post);
}
