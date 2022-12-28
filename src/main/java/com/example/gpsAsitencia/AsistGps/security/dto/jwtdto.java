package com.example.gpsAsitencia.AsistGps.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class jwtdto {
	
	private String toke;
	private String bearer = "Bearer";
	private String nombreusu;
	private Collection<? extends GrantedAuthority> authorities;
	
	public jwtdto(String toke, String nombreusu, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.toke = toke;
		this.nombreusu = nombreusu;
		this.authorities = authorities;
	}

	public String getToke() {
		return toke;
	}

	public void setToke(String toke) {
		this.toke = toke;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getNombreusu() {
		return nombreusu;
	}

	public void setNombreusu(String nombreusu) {
		this.nombreusu = nombreusu;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	

}
