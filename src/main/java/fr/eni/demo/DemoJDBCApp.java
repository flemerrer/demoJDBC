package fr.eni.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoJDBCApp {

	public static void main(String[] args) {
//		SpringApplication.run(DemoSwellApplication.class, args);
		ApplicationContext context = SpringApplication.run(DemoJDBCApp.class, args);
//		FormateurRepository repo = context.getBean("formateurRepository", FormateurRepository.class);
//		Formateur contact = new Formateur("françois", "le merrer");
//		repo.insert(contact);
//		System.out.println(repo.findAll());
	}

}
