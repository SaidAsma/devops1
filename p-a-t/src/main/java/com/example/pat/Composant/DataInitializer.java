package com.example.pat.Composant;

import com.example.pat.entites.Utilisateur;
import com.example.pat.repository.CommandeRepository;
import com.example.pat.repository.FactureRepository;
import com.example.pat.repository.ProduitRepository;
import com.example.pat.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/*
@Component
@Transactional
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FactureRepository factureRepository;

    @Override
    public void run(String... args) {
        // Création d'utilisateurs
        Utilisateur admin = new Utilisateur();
        admin.setNom("admin");

        admin.setEmail("admin@example.com");
        admin.setRole(Role.ADMIN);
        utilisateurRepository.save(admin);

        Utilisateur user = new Utilisateur();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setEmail("user@example.com");
        user.setRole(Role.USER);
        utilisateurRepository.save(user);

        // Création de produits
        Produit produit1 = new Produit();
        produit1.setNom("Produit A");
        produit1.setPrix(29.99);
        produitRepository.save(produit1);

        Produit produit2 = new Produit();
        produit2.setNom("Produit B");
        produit2.setPrix(49.99);
        produitRepository.save(produit2);

        // Création de commandes
        Commande commande1 = new Commande();
        commande1.setDateCommande(LocalDate.now());
        commande1.setUtilisateur(user); // Associer un utilisateur existant
        commande1.getProduits().add(produit1); // Ajouter des produits à la commande
        commande1.getProduits().add(produit2);
        commandeRepository.save(commande1);

        // Création de factures
        Facture facture1 = new Facture();
        facture1.setCommande(commande1); // Associer une commande existante
        facture1.setMontantTotal(79.98); // Calculer ou définir manuellement le montant total
        facture1.setDateFacture(LocalDate.now());
        factureRepository.save(facture1);
    }
}
*/