package fr.eni.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoJDBCApp {

	public static void main(String[] args) {
		SpringApplication.run(DemoJDBCApp.class, args);
//		ApplicationContext context = SpringApplication.run(DemoJDBCApp.class, args);
	}

}
