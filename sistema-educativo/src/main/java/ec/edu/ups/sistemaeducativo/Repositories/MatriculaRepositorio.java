package ec.edu.ups.sistemaeducativo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.sistemaeducativo.Models.Matricula;

@Repository
public interface MatriculaRepositorio extends JpaRepository<Matricula, Long>{
    
}