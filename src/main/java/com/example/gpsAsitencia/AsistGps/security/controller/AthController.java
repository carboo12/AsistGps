package com.example.gpsAsitencia.AsistGps.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gpsAsitencia.AsistGps.security.dto.NuevoUsuario;
import com.example.gpsAsitencia.AsistGps.security.dto.mensajes;
import com.example.gpsAsitencia.AsistGps.security.jwt.jwtProvider;
import com.example.gpsAsitencia.AsistGps.security.services.RolServices;
import com.example.gpsAsitencia.AsistGps.security.services.UsuarioServices;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AthController {
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UsuarioServices usuarioServices;
	@Autowired
	RolServices rolServices;
	@Autowired
	jwtProvider jwtProvider;
	
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return new ResponseEntity(new mensajes("campos mal puestos"),HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	

}
