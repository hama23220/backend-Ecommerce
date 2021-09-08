package com.mohamed.commerce.dto;

import com.mohamed.commerce.model.Brand;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private Integer id;
    private  String marque;

    public static  BrandDto fromEntity(Brand brand){
        if(brand== null){
            return null;
        }
        return BrandDto.builder()
                .id(brand.getId())
                .marque(brand.getMarque())
                .build();
    }
    public static  Brand toEntity(BrandDto brandDto){
        if (brandDto== null){
            return null;
        }
        Brand brand =new Brand();
        brand.setId(brandDto.getId());
        brand.setMarque(brandDto.getMarque());
        return brand;
    }
}
