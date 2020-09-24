package com.examen.configuration;

import com.examen.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		InputStream body = req.getInputStream();
		User user = new ObjectMapper().readValue(body, User.class);
		Authentication authentication = null;
		try {
			authentication = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					user.getUser(), user.getCPassword(), Collections.emptyList()));
			if (authentication.isAuthenticated()) {
				LOGGER.debug("Logging exitoso!");
			}
		} catch (Exception e) {
			if (e.getMessage().equals("Invalidas credenciales")) {
				LOGGER.info("credenciales incorrectas");
			} else {
				LOGGER.error("error!");
			}
		}
		return authentication;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		JwtUtil.addAuthentication(res, auth.getName());
	}
}
