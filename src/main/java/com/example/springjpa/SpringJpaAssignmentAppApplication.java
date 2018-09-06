package com.example.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nageswara.eluri
 *
 */
@SpringBootApplication
@ComponentScan("com.example.*")
public class SpringJpaAssignmentAppApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAssignmentAppApplication.class, args);
	}
}
