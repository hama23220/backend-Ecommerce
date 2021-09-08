package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.BrandApi;
import com.mohamed.commerce.Services.BrandService;
import com.mohamed.commerce.dto.BrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BrandController implements BrandApi {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public BrandDto save(BrandDto dto) {
        return brandService.save(dto);
    }

    @Override
    public BrandDto findById(Integer Brand_ID) {
        return brandService.findById(Brand_ID);
    }

    @Override
    public BrandDto findByMarque(String marque) {
        return brandService.findByMarque(marque);
    }

    @Override
    public List<BrandDto> findAll() {
        return brandService.findAll();
    }

    @Override
    public void delete(Integer Brand_ID) {
    brandService.delete(Brand_ID);
    }
}
