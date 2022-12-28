package com.example.gpsAsitencia.AsistGps.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gpsAsitencia.AsistGps.security.modelo.Usuario;
import com.example.gpsAsitencia.AsistGps.security.repository.UsuarioRepository;



@Service
@Transactional
public class UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getbyNombreUsario(String nombreUsuario) {
        return usuarioRepository.findByNombreUser(nombreUsuario);
    }

    public boolean existNombreUsurio(String nombreUsuario) {
        return usuarioRepository.existfindByNombreUser(nombreUsuario);
    }

    public boolean existNombreCompleto(String NombreCompleto) {
        return usuarioRepository.existfindByNombreCompleto(NombreCompleto);
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void BorrarUsu(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

}
