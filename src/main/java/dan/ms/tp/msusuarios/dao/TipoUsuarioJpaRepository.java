package dan.ms.tp.msusuarios.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import dan.ms.tp.msusuarios.modelo.TipoUsuario;

@Repository
public interface TipoUsuarioJpaRepository extends JpaRepository<TipoUsuario,Integer>{
    
    @Autowired 
    TipoUsuarioJpaRepository tipoUsuarioRepo;

    @Override
    public List<TipoUsuario> buscarPorTipoUsuario(String tipoUsuario) {
        return tipoUsuarioRepo.findAllByTipo(tipoUsuario);
    }


}
