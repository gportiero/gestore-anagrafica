package it.gportiero.registry.services;

import java.util.List;

import it.gportiero.registry.model.RegistryDetails;
import it.gportiero.registry.model.RegistryListItem;

public interface RegistryService {
	public List<RegistryListItem> getList();

	public RegistryDetails getById(long id);
}
