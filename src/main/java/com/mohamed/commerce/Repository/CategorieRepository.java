package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository  extends JpaRepository<Categorie,Integer> {

     List<Categorie> findByParent_Id(Integer id);

     List<Categorie> findByParentIsNull();



}
