package com.mohamed.commerce.dto;

import com.mohamed.commerce.model.Stock;
import com.mohamed.commerce.model.TypeMvtStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class StockDto {
    private Integer id;
    private Instant date;
    private BigDecimal quantite;
    private TypeMvtStock typeMvt;
    private ArticleDto article;


    public static StockDto fromEntity(Stock stock){
        if (stock== null){
            return null;
        }
        return StockDto.builder()
                .id(stock.getId())
                .date(stock.getDate())
                .quantite(stock.getQuantite())
                .typeMvt(stock.getTypeMvt())
                .article(ArticleDto.fromEntity(stock.getArticle()))
                .build();
    }

    public static Stock toEntity(StockDto stockDto){
        if(stockDto == null){
            return null;
        }
        Stock stock =new Stock() ;
        stock.setId(stockDto.getId());
        stock.setDate(stockDto.getDate());
        stock.setQuantite(stockDto.getQuantite());
        stock.setTypeMvt(stockDto.getTypeMvt());
        stock.setArticle(ArticleDto.toEntity(stockDto.getArticle()));
        return stock;
    }
}
