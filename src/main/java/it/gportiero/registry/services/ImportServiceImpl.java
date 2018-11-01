package it.gportiero.registry.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import it.gportiero.registry.domain.Registry;
import it.gportiero.registry.repositories.RegistryRepository;

@Service
public class ImportServiceImpl implements ImportService {

	private final static Logger LOG = LoggerFactory.getLogger(ImportServiceImpl.class);
	
	@Autowired
	private RegistryRepository registryRepository;

	@Autowired
	private SimpMessagingTemplate brokerMessagingTemplate;

	@Async
	public void importCSV(File file) {
		// simulate delay
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e1) {
			// nothing todo
		}

		Reader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			LOG.error("an error occurs during execute method 'importCSV': " + e.getMessage(), e);

			brokerMessagingTemplate.convertAndSend("/topics/import/status", false);
			return;
		}

		@SuppressWarnings("unchecked")
		CsvToBean<Registry> csvToBean = new CsvToBeanBuilder<Registry>(reader).withType(Registry.class)
				.withIgnoreLeadingWhiteSpace(true).build();

		List<Registry> registries = csvToBean.parse();

		registryRepository.save(registries);

		brokerMessagingTemplate.convertAndSend("/topics/import/status", true);
	}
}