package com.project.findmytutor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.findmytutor.domain.CustomUserDetails;
import com.project.findmytutor.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfigure {

    @Bean
	public UserDetails userDetails() {
		return new CustomUserDetails();
	}

    @Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** retrieve user information from a database for UserDetailsService **/
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
    
    // ignore h2 database API
    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
    //     return (web) -> web.ignoring().antMatchers("/h2-console/**", "/favicon.ico");
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF config Disable
    http.csrf().disable()

        // config for h2-console
        .headers()
        .frameOptions()
        .sameOrigin()

        // requests handling
        .and()
        .authenticationProvider(authenticationProvider())
        .authorizeRequests()
        .antMatchers("/account/**").authenticated()
        .anyRequest().permitAll()

        .and()
        .formLogin().loginPage("/")

        .and()
        .logout()
            .permitAll()
            .logoutSuccessHandler(new CustomLogoutSuccessHandler())
            .logoutSuccessUrl("/");

        return http.build();
    }
}
