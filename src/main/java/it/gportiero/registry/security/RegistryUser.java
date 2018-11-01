package it.gportiero.registry.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class RegistryUser extends User {

	private static final long serialVersionUID = 1209174484988203066L;

	public RegistryUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
}
