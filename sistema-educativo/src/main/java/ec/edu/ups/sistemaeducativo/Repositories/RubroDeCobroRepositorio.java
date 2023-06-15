package ec.edu.ups.sistemaeducativo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.RubroDeCobro;

@Repository
public interface RubroDeCobroRepositorio extends JpaRepository<RubroDeCobro, Long>{
    
    Optional<RubroDeCobro> findRubroPorAreaDeTrabajo(String admAreaDeTrabajo);
}
