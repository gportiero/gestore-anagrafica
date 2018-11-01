package it.gportiero.registry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.gportiero.registry.model.RegistryDetails;
import it.gportiero.registry.services.ImportService;
import it.gportiero.registry.services.RegistryService;

@Controller
@RequestMapping("/registries")
public class RegistryController {

	@Autowired
	private RegistryService registryService;
	
	@Autowired
	private ImportService importService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("registries", registryService.getList());
		return "registry-list";
	}

	@GetMapping("/{id}")
	public String byId(@PathVariable("id") Long id, Model model) {
		RegistryDetails registryDetails = registryService.getById(id);

		if (registryDetails == null) {
			return "redirect:/";
		}

		model.addAttribute("registry", registryDetails);
		return "registry-details";
	}

	@GetMapping("/import")
	public String importForm(Model model) {
		return "import-form";
	}

	@PostMapping("/import")
	public String importCSVFile(@RequestParam("file") MultipartFile file) {

		importService.importCSV(file);

		return "redirect:/";
	}
}
