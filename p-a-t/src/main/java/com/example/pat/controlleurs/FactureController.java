package com.example.pat.controlleurs;


import com.example.pat.entites.Facture;
import com.example.pat.repository.CommandeRepository;
import com.example.pat.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/factures")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping
    public String listFactures(Model model) {
        model.addAttribute("factures", factureRepository.findAll());
        return "factures/liste";
    }

    @GetMapping("/ajouter")
    public String formFacture(Model model) {
        model.addAttribute("facture", new Facture());
        model.addAttribute("commandes", commandeRepository.findAll()); // Liste des commandes pour associer à la facture
        return "factures/form";
    }

    @PostMapping
    public String saveFacture(@ModelAttribute Facture facture) {
        factureRepository.save(facture);
        return "redirect:/factures";
    }

    @GetMapping("/modifier/{id}")
    public String editFacture(@PathVariable Long id, Model model) {
        Facture facture = factureRepository.findById(id).orElse(null);
        if (facture != null) {
            model.addAttribute("facture", facture);
            model.addAttribute("commandes", commandeRepository.findAll());
            return "factures/form";
        }
        return "redirect:/factures";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteFacture(@PathVariable Long id) {
        factureRepository.deleteById(id);
        return "redirect:/factures";
    }

}
