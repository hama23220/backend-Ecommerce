package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.Declinision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeclinisionRepository extends JpaRepository<Declinision,Integer> {

    Optional<Declinision> findByCouleur(String couleur);

   Optional <Declinision> findByTaille(String taille);
}
