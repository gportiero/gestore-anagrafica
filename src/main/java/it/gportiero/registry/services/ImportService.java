package it.gportiero.registry.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {
	public void importCSV(MultipartFile file);
}
