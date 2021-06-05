package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.Post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Contratado implements Serializable {

    @Id
    private Long id;
    private String descripcion;
    private LocalDate fecha;
    private String nombre;
    private String especialidad;
    private String matricula;
    private String imagen;
    public Contratado() {
        this.fecha = LocalDate.now();
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
