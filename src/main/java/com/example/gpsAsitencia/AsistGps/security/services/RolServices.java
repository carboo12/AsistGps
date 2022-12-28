package com.example.gpsAsitencia.AsistGps.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gpsAsitencia.AsistGps.security.modelo.Tipousuario;
import com.example.gpsAsitencia.AsistGps.security.repository.RolRepository;


@Service
@Transactional
public class RolServices {
    @Autowired
    RolRepository rolRepository;

    public Optional<Tipousuario> getByRolNombre(Tipousuario tipousuario) {
        return rolRepository.findByTipo(tipousuario);

    }

}
