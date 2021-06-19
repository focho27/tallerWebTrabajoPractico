package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository("repositorioContratado")
public class RepositorioContratadoImpl implements RepositorioContratado {
    private SessionFactory sessionFactory;

    public RepositorioContratadoImpl(){
    }
    @Autowired
    public RepositorioContratadoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Contratado> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Contratado");
        return query.list()!=null?query.list():null;
    }

    @Override
    @Transactional
    public Contratado postFindById(Long id) {
        return sessionFactory.getCurrentSession().get(Contratado.class, id);
    }

    @Override
    @Transactional
    public void save(Contratado contratado) {
        sessionFactory.getCurrentSession().save(contratado);
    }

    @Override
    @Transactional
    public void delete(Contratado contratado) {
        sessionFactory.getCurrentSession().delete(contratado);
    }

    @Override
    public List<Contratado> findByCodContrantante(String usuarioConectado) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Contratado where codContratante = :usuarioConectado");
        query.setParameter("usuarioConectado", usuarioConectado);
        List<Contratado> contratados = query.list();
        return contratados;
    }

}