package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioUsuario {
    Usuario buscarUsuarioPorMatricula(String matricula);
    void save(Usuario usuario);
    void update(Usuario usuario);

}
