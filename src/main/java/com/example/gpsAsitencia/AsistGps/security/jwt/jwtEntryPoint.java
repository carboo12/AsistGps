package com.example.gpsAsitencia.AsistGps.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class jwtEntryPoint  implements AuthenticationEntryPoint{
	
	private final static Logger logger = LoggerFactory.getLogger(jwtEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Falla en el metodo Comment");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Respuesta no Autorizada");
		
	} 

	

}
