package com.project.findmytutor;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.findmytutor.domain.Lesson;
import com.project.findmytutor.domain.Member;
import com.project.findmytutor.repository.LessonRepository;
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
	ApplicationRunner applicationRunner(MemberRepository memberRepository, LessonRepository lessonRepository) {
		return args -> {
			memberRepository.save(new Member(null, 
											"gp2693@gmail.com", 
											passwordEncoder.encode("1234"), 
											"Gyuseok Park", 
											"0123456789", 
											"New York", 
											"tutor"));
			memberRepository.save(new Member(null, 
											"gp2693@naver.com", 
											passwordEncoder.encode("1234"), 
											"Gs Park", 
											"9876543210", 
											"New Jersey", 
											"student"));
			lessonRepository.save(new Lesson(null, 
											"online", 
											"programming", 
											"40", 
											null, 
											memberRepository.findByEmail("gp2693@gmail.com").orElseThrow()));
			lessonRepository.save(new Lesson(null, 
											"online", 
											"programming", 
											"45", 
											null, 
											memberRepository.findByEmail("gp2693@gmail.com").orElseThrow()));
		};
	}
}
