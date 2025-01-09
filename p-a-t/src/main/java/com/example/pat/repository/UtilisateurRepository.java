package com.example.pat.repository;


import com.example.pat.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    Utilisateur findByEmail(String email);
}