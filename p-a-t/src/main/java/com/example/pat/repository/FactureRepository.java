package com.example.pat.repository;


import com.example.pat.entites.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    Facture findByCommandeId(Long commandeId);
}

