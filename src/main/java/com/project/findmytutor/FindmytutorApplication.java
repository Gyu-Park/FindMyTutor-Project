package com.project.findmytutor;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.findmytutor.domain.Member;
import com.project.findmytutor.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class FindmytutorApplication {

	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FindmytutorApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(MemberRepository memberRepository) {
		return args -> {
			memberRepository.save(new Member(null, "gp2693@gmail.com", passwordEncoder.encode("1234"), "Gyuseok", "Park", "0123456789", "New York", "Tutor"));
		};
	}
}
