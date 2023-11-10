package dan.ms.tp.msusuarios.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer>{
    
    @Autowired
    UsuarioJpaRepository usuarioRepo;

    @Override
    public Usuario guardarUsuario (Usuario u) {
        return usuarioRepo.save(u);
    }

    public Usuario buscarPorIdUsuario (Integer id) {
        return usuarioRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("no"));
    }

    public void borrarUsuario (Integer id) {
        usuarioRepo.deleteById(id);
    }

    public Usuario buscarPorClienteUsuario (Cliente cliente) {
        return usuarioRepo.findByCliente(cliente);
    }

    public Usuario buscarPorTipUsuario (TipoUsuario tipoUsuario) {
        return usuarioRepo.findByTipoUsuario(tipoUsuario);
    }
    /*

    public Cliente buscarPorCUITCliente (String cuit) {
        return clienteRepo.findByCuit(cuit);
    } */
}
