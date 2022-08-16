package com.project.findmytutor;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.findmytutor.model.Member;
import com.project.findmytutor.repository.MemberRepository;

@SpringBootApplication
public class FindmytutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindmytutorApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(MemberRepository memberRepository) {
		return args -> {
			memberRepository.save(new Member(null, "gp2693@gmail.com", "1234", "Gyuseok Park", "0123456789", "New York", "Tutor"));
		};
	}
}
