package fr.eni.demo.controllers;

import fr.eni.demo.entities.Formateur;
import fr.eni.demo.repositories.FormateurRepository;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("/")
public class FormateurController {

	private FormateurRepository formateurRepository;

	public FormateurController(FormateurRepository formateurRepository) {
		this.formateurRepository = formateurRepository;
	}

	// ETAPE 1
	@GetMapping("/")
	public Object index() {
		var mav = new ModelAndView("index");
		mav.addObject("formateur", new fr.eni.demo.bo.Formateur());
		mav.addObject("formateurs", formateurRepository.findAll());
		return mav;
	}

	// ETAPE 3
	@PostMapping("/formateur/save")
	public Object save(Formateur formateur) {
		System.out.println(formateur);
		formateurRepository.insert(formateur);
		return "redirect:/";
	}

}
