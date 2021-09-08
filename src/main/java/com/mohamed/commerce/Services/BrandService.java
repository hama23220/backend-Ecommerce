package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.BrandDto;

import java.util.List;

public interface BrandService {

    BrandDto save(BrandDto dto);

    BrandDto findById(Integer Brand_ID);

    BrandDto findByMarque(String marque);

    List<BrandDto> findAll();

    void delete(Integer Brand_ID);


}
