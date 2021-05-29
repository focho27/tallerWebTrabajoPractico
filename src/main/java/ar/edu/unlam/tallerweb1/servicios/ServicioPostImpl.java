package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Service("servicioPost")
@Transactional
public class ServicioPostImpl implements ServicioPost{

    private RepositorioPost postDao;
    @Autowired
    public ServicioPostImpl(RepositorioPost postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> findAll() {

        return postDao.findAll()!=null?postDao.findAll():null;
    }

    @Override
    public Post postFindById(Long id) {
        return postDao.postFindById(id);
    }

    @Override
    public void save(Post post) {
        postDao.save(post);
    }

    @Override
    public void delete(Post post) {
    postDao.delete(post);
    }

    @Override
    public List<Post> findAllByMatricula(String matricula) throws SQLException, NamingException, ClassNotFoundException {
        return postDao.findAllByMatricula(matricula);
    }
}
