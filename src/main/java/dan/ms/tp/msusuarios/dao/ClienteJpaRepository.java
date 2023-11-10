package dan.ms.tp.msusuarios.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import dan.ms.tp.msusuarios.modelo.Cliente;

public interface ClienteJpaRepository extends JpaRepository<Cliente,Integer> {
    
    @Autowired
    ClienteJpaRepository clienteRepo;

    //El save funciona tanto como para insertar como para actualizar. 
    @Override
    public Cliente guardarCliente (Cliente c) {
        return clienteRepo.save(c);
    }

    public Cliente buscarPorIdCliente (Integer id) {
        return clienteRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("no"));
    }

    public void borrarCliente (Integer id) {
        clienteRepo.deleteById(id);
    }

    public Cliente buscarPorCUITCliente (String cuit) {
        return clienteRepo.findByCuit(cuit);
    }
}
