package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RepositorioContratado {

    List<Contratado> findAll();
    Contratado postFindById(Long id);
    void save(Contratado contratado);
    void delete(Contratado contratado);
}
