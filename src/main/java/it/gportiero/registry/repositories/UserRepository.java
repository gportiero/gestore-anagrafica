package it.gportiero.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.gportiero.registry.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
