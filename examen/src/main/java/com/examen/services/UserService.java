package com.examen.services;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ResourceUtils;

@Service
public class UserService implements UserDetailsService {

	public static String[] obtenerDatos() throws IOException {
		File file = ResourceUtils.getFile("classpath:users.txt");

		String content = new String(Files.readAllBytes(file.toPath()));
		String users[] = content.split("\\|");
		return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String user = "";
		String password = "";
		try {
			String users[] = obtenerDatos();
			for (String us : users) {
				String credenciales[] = us.split("\\,");
				String useR = credenciales[0];
				String p = credenciales[1];

				if (username.equals(credenciales[0])) {
					user = useR;
					password = p;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new User(user, encoder.encode(password), buildGrante(3));
	}

	public List<GrantedAuthority> buildGrante(int rol) {
		String[] roles = { "READER", "USER", "ADMIN" };
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (int i = 0; i < rol; i++) {
			authorities.add(new SimpleGrantedAuthority(roles[i]));
		}
		return authorities;
	}

}
