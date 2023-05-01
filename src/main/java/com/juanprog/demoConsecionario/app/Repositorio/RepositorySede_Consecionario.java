package com.juanprog.demoConsecionario.app.Repositorio;

import com.juanprog.demoConsecionario.app.Entity.Sede_Consecionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorySede_Consecionario extends JpaRepository<Sede_Consecionario, Integer>{
    @Query(value = "SELECT s FROM Sede_Consecionario s WHERE s.id=id")
    public Sede_Consecionario encontrarId(int id);

}
