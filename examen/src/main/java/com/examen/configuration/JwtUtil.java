package com.examen.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Collections.emptyList;

public class JwtUtil {

///Envia el token de autenticacion
	static void addAuthentication(HttpServletResponse res, String username){
		String token = Jwts.builder()
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, "P@tit0").compact();
		res.addHeader("Authorization", "Bearer " + token);
	}

///Valida el token de autenticacion
	static Authentication getAuthentication(HttpServletRequest request){
		String token = request.getHeader("Authorization");
		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}
}
