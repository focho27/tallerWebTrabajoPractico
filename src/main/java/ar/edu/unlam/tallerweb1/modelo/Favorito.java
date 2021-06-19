package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Favorito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFav;
    private String codUsuario;
    private Long postFav;

    public Long getPostFav() { return postFav; }
    public void setPostFav(Long postFav) { this.postFav = postFav; }

    public String getCodUsuario() { return codUsuario; }
    public void setCodUsuario(String codUsuario) { this.codUsuario = codUsuario; }

}
