package com.quizApp.Quiz_app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration

public class SecurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//Basic cmFuZ2EyOmR1bW15
        //Basic cmFuZ2EyOmR1bW15
        http.authorizeHttpRequests(
                auth->{
                    auth
                            .requestMatchers("/basicauth").permitAll()
                            //.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                            .requestMatchers(HttpMethod.OPTIONS,"/quiz/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.OPTIONS,"/question/**").hasRole("USER")

                            .anyRequest().authenticated()
                            ;
                }
        );
        http.sessionManagement(
                session->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
        );
        http.httpBasic(Customizer.withDefaults());
        http.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));
        http.csrf(csrf->csrf.disable());
       // http.addFilterBefore(new HttpBasicAuthenticationFilter(authenticationManager()), OncePerRequestFilter.class);

        //  http.requestMatchers("/quiz/**", "/question/**").headers(headers -> headers.add("Authorization", "Basic " + BASE64_CREDENTIALS));
        return http.build();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailService);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
