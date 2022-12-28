package com.example.gpsAsitencia.AsistGps.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.gpsAsitencia.AsistGps.security.services.UsuarioDetailServiceImp;


public class jwtTokenFilter extends OncePerRequestFilter {

	private final static Logger logger = LoggerFactory.getLogger(jwtTokenFilter.class);

	@Autowired
	jwtProvider jwtProvider;

	@Autowired
	UsuarioDetailServiceImp usuarioDetailServiceImp;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(request);
			if (token != null && jwtProvider.validarToke(token)) {
				String nombreUsuario = jwtProvider.getNombreUsuarioToken(token);
				UserDetails userDetails = usuarioDetailServiceImp.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}

		} catch (Exception e) {
			logger.error("falla en el proceso de llenado");
		}
		filterChain.doFilter(request, response);

	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer")) {
			return header.replace("Bearer", "");
		} else {
			return null;
		}

	}

}