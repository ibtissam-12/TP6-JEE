package dao;

import model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements ProduitDAO {
    private List<Produit> produits = new ArrayList<>();

    public void init() {
        System.out.println("Initialisation DAO");
    }

    @Override
    public void addProduit(Produit p) {
        p.setIdProduit((long) (produits.size() + 1));
        produits.add(p);
    }

    @Override
    public void deleteProduit(Long id) {
        produits.removeIf(p -> p.getIdProduit().equals(id));
    }

    @Override
    public Produit getProduitById(Long id) {
        return produits.stream()
                .filter(p -> p.getIdProduit().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produits;
    }

    @Override
    public void updateProduit(Produit p) {
        Produit existing = getProduitById(p.getIdProduit());
        if (existing != null) {
            existing.setNom(p.getNom());
            existing.setDescription(p.getDescription());
            existing.setPrix(p.getPrix());
        }
    }
}