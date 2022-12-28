package com.example.gpsAsitencia.AsistGps.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gpsAsitencia.AsistGps.security.modelo.Tipousuario;



@Repository
public interface RolRepository extends JpaRepository<Tipousuario, Integer> {
    Optional<Tipousuario> findByTipo(Tipousuario tipousuario);

}
