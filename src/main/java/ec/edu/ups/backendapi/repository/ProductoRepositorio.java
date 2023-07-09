package ec.edu.ups.backendapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.backendapi.model.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    
    Optional<Producto> findProductoByNombre(String nombre);
}