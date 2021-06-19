package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Puntaje implements Serializable {

    @Id
    private String matriculaEspecialidad;
    private Long num_votes = 0L;
    private Long actual_vote = 0L;
    private Long total_score = 0L;
    private Long rating = 0L;

    public String getMatriculaEspecialidad() { return matriculaEspecialidad; }
    public void setMatriculaEspecialidad(String matriculaEspecialidad) { this.matriculaEspecialidad = matriculaEspecialidad; }

    public Long getNum_votes() { return num_votes; }
    public void setNum_votes(Long num_votes) { this.num_votes = num_votes; }

    public Long getTotal_score() { return total_score; }
    public void setTotal_score(Long total_score) { this.total_score = total_score; }

    public Long getRating() { return rating; }
    public void setRating(Long rating) { this.rating = rating; }

    public Long getActual_vote() { return actual_vote; }
    public void setActual_vote(Long actual_vote) { this.actual_vote = actual_vote; }

}
