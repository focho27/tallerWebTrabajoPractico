package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Contratado;
import ar.edu.unlam.tallerweb1.modelo.Post;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioContratado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service("servicioContratado")
@Transactional
public class ServicioContratadoImpl implements ServicioContratado {

    private RepositorioContratado contratadoDao;



    @Autowired
    public ServicioContratadoImpl(RepositorioContratado contratadoDao) {
        this.contratadoDao = contratadoDao;
    }

    @Override
    public List<Contratado> findAll() {

        return contratadoDao.findAll() != null ? contratadoDao.findAll() : null;
    }

    @Override
    public Contratado postFindById(Long id) {
        return contratadoDao.postFindById(id);
    }

    @Override
    public void save(Contratado contratado) {
        contratadoDao.save(contratado);
    }

    @Override
    public void delete(Contratado contratado) {
        contratadoDao.delete(contratado);
    }

    @Override
    public void asignarParametros(Post post, String codUsuarioConectado) {
        Contratado contratado = new Contratado();

        contratado.setId(post.getId());
        contratado.setNombre(post.getNombre());
        contratado.setDescripcion(post.getDescripcion());
        contratado.setMatricula(post.getMatricula());
        contratado.setEspecialidad(post.getEspecialidad());
        contratado.setFecha(post.getFecha());
        contratado.setImagen(post.getImagen());
        contratado.setZona(post.getZona());
        contratado.setCodContratante(codUsuarioConectado);
        contratadoDao.save(contratado);
    }

    @Override
    public List<Contratado> findbyCodContratante(String usuarioConectado) {
        return contratadoDao.findByCodContrantante(usuarioConectado);
    }
    }
