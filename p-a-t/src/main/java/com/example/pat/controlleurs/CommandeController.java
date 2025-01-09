package com.example.pat.controlleurs;

import com.example.pat.entites.Commande;
import com.example.pat.entites.Utilisateur;
import com.example.pat.repository.CommandeRepository;
import com.example.pat.repository.ProduitRepository;
import com.example.pat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.pat.entites.Produit;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private UtilisateurRepository userRepository;

    // Afficher la liste des commandes
    @GetMapping
    public String listCommandes(Model model) {
        model.addAttribute("commandes", commandeRepository.findAll());
        return "commandes/list";
    }

    // Formulaire d'ajout de commande
    @GetMapping("/ajouter")
    public String showAddForm(Model model) {
        model.addAttribute("commande", new Commande());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("produits", produitRepository.findAll());
        return "commandes/form";
    }

    // Ajouter une commande
    @PostMapping("/ajouter")
    public String addCommande(@ModelAttribute Commande commande, @RequestParam List<Long> produitIds, @RequestParam Long userId) {
        List<Produit> produits = produitRepository.findAllById(produitIds);
       Utilisateur user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        commande.setProduits(produits);
        commande.setUtilisateur(user);
        commande.setDateCommande(new Date());
        commandeRepository.save(commande);
        return "redirect:/commandes";
    }

    // Formulaire de modification
    @GetMapping("/modifier/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Commande introuvable : " + id));
        model.addAttribute("commande", commande);
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("produits", produitRepository.findAll());
        return "commandes/form";
    }

    // Modifier une commande
    @PostMapping("/modifier/{id}")
    public String updateCommande(@PathVariable Long id, @ModelAttribute Commande commande, @RequestParam List<Long> produitIds, @RequestParam Long userId) {
        List<Produit> produits = produitRepository.findAllById(produitIds);
       Utilisateur user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        commande.setId(id);
        commande.setProduits(produits);
        commande.setUtilisateur(user);
        commandeRepository.save(commande);
        return "redirect:/commandes";
    }

    // Supprimer une commande
    @GetMapping("/supprimer/{id}")
    public String deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);
        return "redirect:/commandes";
    }
}

