package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
public class Usuario implements Serializable {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String codigo;
	private String email;
	private String password;
	private String rol;
	private String direccion;
	private String telefono;
	private String nombre;
	private String apellido;


	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.


	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getCodigo() { return codigo; }
	public void setCodigo(String codigo) { this.codigo = codigo; }

	public String getRol() { return rol; }
	public void setRol(String rol) { this.rol = rol; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }

	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


}
