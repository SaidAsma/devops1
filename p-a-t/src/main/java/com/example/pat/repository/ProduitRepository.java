package com.example.pat.repository;


import com.example.pat.entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    List<Produit> findByNomContaining(String nom);
}