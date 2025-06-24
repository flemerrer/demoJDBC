package fr.eni.demo;

import fr.eni.demo.entities.Formateur;
import fr.eni.demo.repositories.FormateurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSwellApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoSwellApplication.class, args);
		ApplicationContext context = SpringApplication.run(DemoSwellApplication.class, args);
//		FormateurRepository repo = context.getBean("formateurRepository", FormateurRepository.class);
//		Formateur contact = new Formateur("françois", "le merrer");
//		repo.insert(contact);
//		System.out.println(repo.findAll());
	}

}
