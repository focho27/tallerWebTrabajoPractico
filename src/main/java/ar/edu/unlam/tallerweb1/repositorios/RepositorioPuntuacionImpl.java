package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("RepositorioPuntuacion")
public class RepositorioPuntuacionImpl implements RepositorioPuntuacion{
    private SessionFactory sessionFactory;

    public RepositorioPuntuacionImpl(){
    }

    @Autowired
    public RepositorioPuntuacionImpl(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory; }


    @Override
    public void save(Puntaje puntaje) { sessionFactory.getCurrentSession().save(puntaje);
    }

    @Override
    public List<Puntaje> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Puntaje");
        return query.list()!=null?query.list():null;
    }

    @Override
    @Transactional
    public void update(Puntaje puntaje){ sessionFactory.getCurrentSession().update(puntaje); }

    @Override
    @Transactional
    public Puntaje buscarPuntajePorMatriculaEspecialidad(String matricula, String especialidad) {
        return sessionFactory.getCurrentSession().get(Puntaje.class, matricula+especialidad); }




}
