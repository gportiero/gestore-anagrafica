package it.gportiero.registry.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gportiero.registry.domain.Registry;
import it.gportiero.registry.model.RegistryDetails;
import it.gportiero.registry.model.RegistryListItem;
import it.gportiero.registry.repositories.RegistryRepository;

@Service
public class RegistryServiceImpl implements RegistryService {

	@Autowired
	private RegistryRepository registryRepository;

	public List<RegistryListItem> getList() {
		List<Registry> registries = registryRepository.findAll();

		return registries.stream().map(r -> {
			RegistryListItem item = new RegistryListItem();
			item.setId(r.getId());
			item.setName(r.getFirstName() + " " + r.getLastName());
			return item;
		}).collect(Collectors.toList());
	}

	public RegistryDetails getById(long id) {
		Registry registry = registryRepository.findOne(id);
		if (registry == null) {
			return null;
		}

		return toDetails(registry);
	}

	private RegistryDetails toDetails(Registry registry) {
		RegistryDetails rDetails = new RegistryDetails();
		rDetails.setId(registry.getId());
		rDetails.setFirstName(registry.getFirstName());
		rDetails.setLastName(registry.getLastName());
		rDetails.setBirthDate(registry.getBirthDate());
		rDetails.setCountry(registry.getCountry());
		rDetails.setFiscalCode(registry.getFiscalCode());

		return rDetails;
	}
}
