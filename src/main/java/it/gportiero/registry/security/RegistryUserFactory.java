package it.gportiero.registry.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import it.gportiero.registry.domain.User;

public final class RegistryUserFactory {

	private RegistryUserFactory() {

	}

	/**
	 * Create a RegistryUser object
	 *
	 * @param user
	 *            the user
	 * @return the RegistryUser
	 */
	public static RegistryUser create(User user) {

		return new RegistryUser(user.getUsername(), user.getPassword(), mapToGrantedAuthorities(Arrays.asList("user")));
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {

		if (authorities.isEmpty()) {
			return new ArrayList<>();
		}

		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority))
				.collect(Collectors.toList());
	}
}
