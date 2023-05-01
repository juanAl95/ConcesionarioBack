package com.juanprog.demoConsecionario.app.Repositorio;

import com.juanprog.demoConsecionario.app.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVenta extends JpaRepository<Venta,Integer> {
    @Query(value = "SELECT v FROM Venta v WHERE v.id=id")
    public Venta encontrarId(int id);

}
