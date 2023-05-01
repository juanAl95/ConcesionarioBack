package com.juanprog.demoConsecionario.app.Repositorio;

import com.juanprog.demoConsecionario.app.Entity.Rol_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRol_Usuario extends JpaRepository<Rol_Usuario,Integer> {
    @Query(value = "SELECT r FROM Rol_Usuario r WHERE r.id=id")
    public Rol_Usuario encontrarId(int id);
}
