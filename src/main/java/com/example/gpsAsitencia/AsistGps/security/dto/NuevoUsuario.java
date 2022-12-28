package com.example.gpsAsitencia.AsistGps.security.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;

public class NuevoUsuario {
	@NotBlank
	private String NombreCompleto;
	@NotBlank
	private String NombreUsu;
	@NotBlank
	private String contraseña;
	private Set<String> roles = new HashSet<>();
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
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
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	

}
