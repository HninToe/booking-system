package org.bookingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Web security configuration
 *
 * @author HninHninToe
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    /**
     * Constructor
     */
    public WebSecurityConfig() {

    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        // TODO implement auth
        http
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().permitAll());

        return http.build();
    }

    /**
     * Ignore the authentication.
     *
     * @return ignored list for static files
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**");
    }

}
