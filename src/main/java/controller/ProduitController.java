package controller;

import model.Produit;
import services.ProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProduitController {

    @Autowired
    private ProduitMetier services;

    // HOME PAGE
    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // ADD
    @PostMapping("/addProduit")
    public String addProduit(Model model, Produit p) {
        services.addProduit(p);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // DELETE
    @GetMapping("/deleteProduit")
    public String deleteProduit(Model model, @RequestParam Long id) {
        services.deleteProduit(id);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // EDIT
    @GetMapping("/editProduit")
    public String editProduit(Model model, @RequestParam Long id) {
        model.addAttribute("produitEdit", services.getProduitById(id));
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    // UPDATE
    @PostMapping("/updateProduit")
    public String updateProduit(Model model,
                                @RequestParam Long idProduit,
                                @RequestParam String nom,
                                @RequestParam String description,
                                @RequestParam Double prix) {

        Produit p = new Produit(nom, description, prix);
        p.setIdProduit(idProduit);

        services.updateProduit(p);

        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }
}
