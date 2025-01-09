package com.example.pat.controlleurs;

import com.example.pat.entites.Produit;
import com.example.pat.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.example.pat.entites.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    // Afficher la liste des produits
    @GetMapping
    public String listProduits(Model model) {
        model.addAttribute("produits", produitRepository.findAll());
        return "produit/list";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/ajouter")
    public String showAddForm(Model model) {
        model.addAttribute("produit", new Produit());
        return "produit/form";
    }

    // Ajouter un produit
    @PostMapping("/ajouter")
    public String addProduit(@ModelAttribute Produit produit) {
        produitRepository.save(produit);
        return "redirect:/produits";
    }

    // Afficher le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produit introuvable : " + id));
        model.addAttribute("produit", produit);
        return "produit/form";
    }

    // Modifier un produit
    @PostMapping("/modifier/{id}")
    public String updateProduit(@PathVariable Long id, @ModelAttribute Produit produit) {
        produit.setId(id);
        produitRepository.save(produit);
        return "redirect:/produits";
    }

    // Supprimer un produit
    @GetMapping("/supprimer/{id}")
    public String deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
        return "redirect:/produits";
    }
}
