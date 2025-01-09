package com.example.pat.repository;

import com.example.pat.entites.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    List<Commande> findByUtilisateurId(Long utilisateurId);
}
