package com.example.gpsAsitencia.AsistGps.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
	
	@NotBlank
	private String NombreUsu;
	@NotBlank
	private String contraseña;
	public String getNombreUsu() {
		return NombreUsu;
	}
	public void setNombreUsu(String nombreUsu) {
		NombreUsu = nombreUsu;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
