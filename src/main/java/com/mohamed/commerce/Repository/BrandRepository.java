package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    Optional<Brand> findBrandByMarque(String marque);

}
