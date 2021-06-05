package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);
	Usuario buscarUsuarioPorCodigo(String matricula);
	void save(Usuario usuario);
	void update(Usuario usuario);
}
