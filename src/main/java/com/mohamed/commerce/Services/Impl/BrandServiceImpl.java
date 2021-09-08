package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.EntityNotFoundException;
import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Repository.BrandRepository;
import com.mohamed.commerce.Services.BrandService;
import com.mohamed.commerce.dto.BrandDto;
import com.mohamed.commerce.validator.BrandValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository ;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;

    }

    @Override
    public BrandDto save(BrandDto dto) {
        List<String> errors = BrandValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("brand  n'existe pas{}",dto);
            throw  new InvalidEntityException("Brand n'est pas valide", ErrorCodes.Brand_NOT_VALID,errors);
        }
        return BrandDto.fromEntity(
                brandRepository.save(BrandDto.toEntity(dto))
        );
    }

    @Override
    public BrandDto findById(Integer Brand_ID) {
        if (Brand_ID==null){
            log.error("ID brand est null");
            return null;
        }
        return brandRepository.findById(Brand_ID)
                .map(BrandDto::fromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException(
                                "Aucune brand avec l'ID"+Brand_ID+"n'ete trouve dans la BD",
                                ErrorCodes.Brand_NOT_FOUND
                        ));
    }


    @Override
    public BrandDto findByMarque(String marque) {
        if (!StringUtils.hasLength(marque)){
            log.error("Marque du brand est null");
            return null;
        }
        return brandRepository.findBrandByMarque(marque)
                .map(BrandDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune brand avec l'id="+marque+"n'ete trouve dans la BD",
                        ErrorCodes.Brand_NOT_FOUND
                ));



    }

    @Override
    public List<BrandDto> findAll() {

        return brandRepository.findAll().stream().
                map(BrandDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer Brand_ID) {
        if (Brand_ID==null){
            log.error("ID categorie est null");
        }
        brandRepository.deleteById(Brand_ID);

    }
}
