package com.example.pat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactive la protection CSRF
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/utilisateurs/**", "/commandes/**", "/produits/**", "/factures/**") // Protège les pages des entités utilisateurs, commandes, produits et factures
                        .hasAnyRole("ADMIN", "USER") // Autorise ADMIN et USER à accéder à ces pages
                        .requestMatchers("/login").permitAll()  // Permet l'accès à la page de connexion pour tous les utilisateurs
                        .anyRequest().authenticated()    // Nécessite une authentification pour toutes les autres pages
                )
                .formLogin(form -> form
                            // URL de traitement de la connexion
                        .defaultSuccessUrl("/", true)  // Redirige vers la page d'accueil après une connexion réussie
                        .permitAll()                       // Permet l'accès à la page de connexion sans authentification
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Redirige vers la page de login après la déconnexion
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Utilisation du bcrypt pour le hash des mots de passe
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Création d'utilisateurs en mémoire (exemples d'utilisateurs ADMIN et USER)
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("adminpass")) // Mot de passe crypté
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("userpass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user); // Utilisation d'un utilisateur en mémoire
    }
}
