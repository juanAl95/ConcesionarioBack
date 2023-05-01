package com.juanprog.demoConsecionario.app.Repositorio;

import com.juanprog.demoConsecionario.app.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT u FROM Usuario u WHERE u.id=id")
    public Usuario encontrarId(int id);
}
