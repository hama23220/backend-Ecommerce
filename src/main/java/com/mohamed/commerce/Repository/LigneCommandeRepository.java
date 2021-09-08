package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
    List<LigneCommande> findAllByCommandeClientId(Integer Lignecommande_ID);
    List<LigneCommande> findAllByArticleId(Integer codeArticle);
}
