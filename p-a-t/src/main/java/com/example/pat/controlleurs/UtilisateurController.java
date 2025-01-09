package com.example.pat.controlleurs;

import com.example.pat.entites.Utilisateur;
import com.example.pat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public String getAllUtilisateurs(Model model) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        model.addAttribute("utilisateurs", utilisateurs);
        return "utilisateur/liste"; // Le nom de la vue Thymeleaf (utilisateur/list.html)
    }

    @GetMapping("/{id}")
    public String getUtilisateurById(@PathVariable Long id, Model model) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        model.addAttribute("utilisateur", utilisateur);
        return "utilisateurs/details"; // Le nom de la vue Thymeleaf (utilisateur/details.html)
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur/form"; // Le nom de la vue Thymeleaf pour le formulaire (utilisateur/form.html)
    }

    @PostMapping
    public String createUtilisateur(@ModelAttribute Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return "redirect:/utilisateurs"; // Redirection vers la liste des utilisateurs
    }

    @GetMapping("/modifier/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        model.addAttribute("utilisateur", utilisateur);
        return "utilisateur/form"; // Le nom de la vue Thymeleaf pour le formulaire (utilisateur/form.html)
    }

    @PostMapping("/modifier/{id}")
    public String updateUtilisateur(@PathVariable Long id, @ModelAttribute Utilisateur utilisateur) {
        utilisateur.setId(id);
        utilisateurRepository.save(utilisateur);
        return "redirect:/utilisateurs";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
        return "redirect:/utilisateurs";
    }
}
