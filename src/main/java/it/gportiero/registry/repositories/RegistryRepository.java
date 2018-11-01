package it.gportiero.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.gportiero.registry.domain.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
