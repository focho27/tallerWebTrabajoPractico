package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDate fecha;
    private String nombre;
    private String especialidad;
    //private String puntuacion;
    private String matricula;
    private String imagen;
    public Post() {
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

// public String getPuntuacion() {  return puntuacion; }

    //public void setPuntuacion(String puntuacion) {this.puntuacion = puntuacion;}
}
