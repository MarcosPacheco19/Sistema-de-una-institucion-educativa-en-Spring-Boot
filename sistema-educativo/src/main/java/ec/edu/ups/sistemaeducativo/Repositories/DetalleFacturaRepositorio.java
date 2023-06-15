package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.DetalleFactura;

@Repository
public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Long>{
    
    Optional<DetalleFactura> findDetallePorDescripcion(String detDescripcion);
}
