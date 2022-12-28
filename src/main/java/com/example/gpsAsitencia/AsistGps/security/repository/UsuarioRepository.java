package com.example.gpsAsitencia.AsistGps.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gpsAsitencia.AsistGps.security.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUser(String nombreUser);

    boolean existfindByNombreUser(String nombreUser);

    boolean existfindByNombreCompleto(String nombreCompleto);

}
