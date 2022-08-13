package com.project.findmytutor;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.findmytutor.model.Tutor;
import com.project.findmytutor.repository.TutorRepository;

@SpringBootApplication
public class FindmytutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindmytutorApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(TutorRepository tutorRepository) {
		return args -> {
			tutorRepository.save(new Tutor(null, "gp2693@gmail.com", "Gyuseok Park", "0123456789"));
		};
	}
}
