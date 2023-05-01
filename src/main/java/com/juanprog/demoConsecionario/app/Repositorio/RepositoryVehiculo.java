package com.juanprog.demoConsecionario.app.Repositorio;

import com.juanprog.demoConsecionario.app.Entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehiculo extends JpaRepository<Vehiculo,Integer> {

    @Query(value = "SELECT vh FROM Vehiculo vh WHERE vh.id=id")
    public Vehiculo encontrar(int id);
}
