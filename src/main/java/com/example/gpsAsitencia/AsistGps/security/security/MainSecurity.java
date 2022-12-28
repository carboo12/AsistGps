package com.example.gpsAsitencia.AsistGps.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.gpsAsitencia.AsistGps.security.jwt.jwtEntryPoint;
import com.example.gpsAsitencia.AsistGps.security.jwt.jwtTokenFilter;
import com.example.gpsAsitencia.AsistGps.security.services.UsuarioDetailServiceImp;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioDetailServiceImp usuarioDetailServiceImp;
	@Autowired
	jwtEntryPoint entryPoint;
	
	
    @Bean
	public jwtTokenFilter tokenFilter() {
		return new jwtTokenFilter();
	}
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetailServiceImp).passwordEncoder(passwordEncoder());
		
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/auth/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		
		http.addFilterBefore(tokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	
	

}
