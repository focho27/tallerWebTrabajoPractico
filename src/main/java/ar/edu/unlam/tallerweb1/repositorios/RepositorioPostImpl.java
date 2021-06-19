package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.mysql.cj.protocol.Resultset;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.annotations.AttributeAccessor;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository("repositorioPost")
public class RepositorioPostImpl implements RepositorioPost{
    private SessionFactory sessionFactory;

    public RepositorioPostImpl(){
    }
    @Autowired
    public RepositorioPostImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Post> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Post");
        return query.list()!=null?query.list():null;
    }

    @Override
    @Transactional
    public Post postFindById(Long id) {
        return sessionFactory.getCurrentSession().get(Post.class, id);
    }
    @Override
    @Transactional
    public Boolean postFindByEspecialidadAndMatricula(String especialidad, String matricula) {
        String sSQL="from Post where (especialidad = :esp AND matricula= :mat)";
        Query query = sessionFactory.getCurrentSession().createQuery(sSQL);

        query.setParameter("esp",especialidad);
        query.setParameter("mat",matricula);
        System.out.println(query.list());
        return query.list()!=null && query.list().size()>=1?true:false;
    }

    @Override
    @Transactional
    public void update(Post post) {
        sessionFactory.getCurrentSession().update(post);
    }

    @Override
    @Transactional
    public List<Post> postFindByEspecialidad(String especialidad) {
        String sSQL="from Post where especialidad = :esp";
        Query query = sessionFactory.getCurrentSession().createQuery(sSQL);

        query.setParameter("esp",especialidad);
        return query.list()!=null?query.list():null;
    }

    @Override
    public void guardarFavorito(Favorito favorito) {
        if (buscarUsuarioYPostEnFavorito(favorito.getPostFav(), favorito.getCodUsuario()) == true) {

        }
        else{
            sessionFactory.getCurrentSession().save(favorito);
        }
    }

    @Override
    public Boolean buscarUsuarioYPostEnFavorito(Long postId, String usuarioConectado) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Favorito where (codUsuario = :cod AND postFav = :pf)");
        query.setParameter("cod", usuarioConectado);
        query.setParameter("pf", postId);
        return query.list().size()==1?true:false;
    }

    @Override
    @Transactional
    public void save(Post post) {
        sessionFactory.getCurrentSession().save(post);
    }

    @Override
    @Transactional
    public void delete(Post post) {
        sessionFactory.getCurrentSession().delete(post);
    }

    @Override
    @Transactional
    public List<Post> findAllByMatricula( String matricula)  {

        String sSQL="from Post where matricula = :mat";
        Query query = sessionFactory.getCurrentSession().createQuery(sSQL);
        query.setParameter("mat",matricula);
        return query.list()!=null?query.list():null;
    }
    /*
    *
    *
    @Autowired
    public RepositorioEscuelaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Escuela escuela) {
        sessionFactory.getCurrentSession().save(escuela);
    }

    @Override
    public Escuela buscarPor(Long id) {
        return sessionFactory.getCurrentSession().get(Escuela.class, id);
    }

    @Override
    public List<Escuela> buscarPor(String nombre) {
        return null;
    }
    * */
}
