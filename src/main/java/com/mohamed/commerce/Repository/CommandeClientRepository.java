package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
    Optional<CommandeClient> findCommandeClientByCodeCommande(String code);
    List<CommandeClient> findAllById(Integer id);
}
