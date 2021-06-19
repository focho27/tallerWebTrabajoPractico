package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDate fecha;
    private String nombre;
    private String especialidad;
    private String matricula;
    private String imagen;

    private String zona;
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

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    public List<String> opcionesEspecialidad(){
        List<String> listaEspecialidades = new LinkedList<>();
        listaEspecialidades.add("Plomero");
        listaEspecialidades.add("Gasista");
        listaEspecialidades.add("Electricista");
        listaEspecialidades.add("Pintor");
        listaEspecialidades.add("Piletero");
        listaEspecialidades.add("Tecnico/Reparacion");
        listaEspecialidades.add("Instalacion A/C");
        listaEspecialidades.add("Niniera");
        listaEspecialidades.add("Limpieza");
        listaEspecialidades.add("Albanil");
        listaEspecialidades.add("Jardinero");

        Collections.sort(listaEspecialidades);
        return listaEspecialidades;

    }

    public List<String> opcionesZona(){
        List<String> listaZonas = new LinkedList<>();
        listaZonas.add("Chacarita");
        listaZonas.add("Caballito");
        listaZonas.add("Boedo");
        listaZonas.add("Belgrano");
        listaZonas.add("Barracas");
        listaZonas.add("Balvanera");
        listaZonas.add("Almagro");
        listaZonas.add("Agronomía");
        listaZonas.add("Parque Chacabuco");
        listaZonas.add("Parque Avellaneda");
        listaZonas.add("Palermo");
        listaZonas.add("Núnez");
        listaZonas.add("Nueva Pompeya");
        listaZonas.add("Monserrat");
        listaZonas.add("Monte Castro");
        listaZonas.add("Mataderos");
        listaZonas.add("Liniers");
        listaZonas.add("La Paternal");
        listaZonas.add("La Boca");
        listaZonas.add("Floresta");
        listaZonas.add("Flores");
        listaZonas.add("Constitución");
        listaZonas.add("Colegiales");
        listaZonas.add("Coghlan");
        listaZonas.add("Villa Urquiza");
        listaZonas.add("Villa Soldati");
        listaZonas.add("Villa Santa Rita");
        listaZonas.add("Villa Riachuelo");
        listaZonas.add("Villa Real");
        listaZonas.add("Villa Pueyrredón");
        listaZonas.add("Villa Ortúzar");
        listaZonas.add("Villa Luro");
        listaZonas.add("Villa Lugano");
        listaZonas.add("Villa General Mitre");
        listaZonas.add("Villa Devoto");
        listaZonas.add("Villa del Parque");
        listaZonas.add("Villa Crespo");
        listaZonas.add("Versalles");
        listaZonas.add("Vélez Sárfield");
        listaZonas.add("San Telmo");
        listaZonas.add("San Nicolás");
        listaZonas.add("San Cristóbal");
        listaZonas.add("Saavedra");
        listaZonas.add("Retiro");
        listaZonas.add("Recoleta");
        listaZonas.add("Puerto Madero");
        listaZonas.add("Parque Patricios");
        listaZonas.add("Parque Chas");

        Collections.sort(listaZonas);
        return listaZonas;

    }

// public String getPuntuacion() {  return puntuacion; }

    //public void setPuntuacion(String puntuacion) {this.puntuacion = puntuacion;}
}
