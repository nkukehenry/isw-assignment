package com.nkukehenry.corploans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.http.HttpMethod.OPTIONS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig  {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                http.authorizeHttpRequests(
                        (authorize) -> authorizeReq(authorize))
                        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    private AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizeReq(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize){

        return authorize.anyRequest().permitAll();
/*
        return authorize
                .requestMatchers(OPTIONS).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                .requestMatchers(
                        new AntPathRequestMatcher("/users/**"),
                        new AntPathRequestMatcher("/banks/**"),
                        new AntPathRequestMatcher("/institutions/**"))
                .hasAuthority("VENDOR")
                .requestMatchers(new AntPathRequestMatcher("/loans/**"))
                .hasAnyAuthority("BANKER","USER")
                .requestMatchers(new AntPathRequestMatcher("/loans/request/**"))
                .hasAuthority("USER")
                .anyRequest()
                .authenticated();
*/
    }


}