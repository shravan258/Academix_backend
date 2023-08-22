package com.academix_teacher.security;


import com.academix_teacher.exceptions.CustomAccessDeniedHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    private static final List<String> ALLOWED_ORIGINS = List.of("http://localhost:8100","http://localhost:8300");
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf->csrf.disable())
                .cors(cors -> {
                    cors.configurationSource(corsConfigurationSource());
                })

                .authorizeHttpRequests(auth->{
                    auth.anyRequest().permitAll();
                })
                .exceptionHandling((exception)->{exception.accessDeniedHandler(accessDeniedHandler);})
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration corsConfiguration=new CorsConfiguration();

                corsConfiguration.setAllowedOrigins(ALLOWED_ORIGINS);
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.addAllowedHeader("*");
//                corsConfiguration.addAllowedOriginPattern("**");
                corsConfiguration.addAllowedMethod(HttpMethod.GET);
                corsConfiguration.addAllowedMethod(HttpMethod.POST);
                corsConfiguration.addAllowedMethod(HttpMethod.PUT);
                corsConfiguration.addAllowedMethod(HttpMethod.DELETE);


                return corsConfiguration;
            }
        };
    }

}
