package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.CabeceraFactura;

@Repository
public interface CabeceraFacturaRepositorio extends JpaRepository<CabeceraFactura, Long>{
    
    Optional<CabeceraFactura> findCabeceraPorCorreo(String correo);
}
