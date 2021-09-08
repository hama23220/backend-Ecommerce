package com.mohamed.commerce.Services.Impl;

import com.mohamed.commerce.Exception.ErrorCodes;
import com.mohamed.commerce.Exception.InvalidEntityException;
import com.mohamed.commerce.Repository.StockRepository;
import com.mohamed.commerce.Services.ArticleService;
import com.mohamed.commerce.Services.StockService;
import com.mohamed.commerce.dto.StockDto;
import com.mohamed.commerce.model.TypeMvtStock;
import com.mohamed.commerce.validator.StockValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository ;
    private ArticleService articleService;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository, ArticleService articleService) {
        this.stockRepository = stockRepository;
        this.articleService = articleService;
    }

    @Override
    public BigDecimal stockReelArticle(Integer Article_ID) {
    if (Article_ID==null){
        log.warn("L'article id est null");
        return BigDecimal.valueOf(-1);
    }
    articleService.findById(Article_ID);
    return stockRepository.stockReelArticle(Article_ID);

    }


    @Override
    public List<StockDto> stockArticle(Integer Article_ID) {
        return stockRepository.findAllByArticleId(Article_ID).stream()
                .map(StockDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public StockDto entreeStock(StockDto dto) {
        return entreePositive(dto,TypeMvtStock.ENTREE);
    }

    @Override
    public StockDto sortieStock(StockDto dto) {
        return sortieNegative(dto,TypeMvtStock.SORTIE);
    }

    @Override
    public StockDto correctionStockPos(StockDto dto) {
        return entreePositive(dto,TypeMvtStock.CORRECTION_POS);
    }

    @Override
    public StockDto correctionStockNeg(StockDto dto) {
        return sortieNegative(dto,TypeMvtStock.CORRECTION_NEG);
    }

    private StockDto entreePositive(StockDto dto, TypeMvtStock typeMvtStock){
        List<String> errors= StockValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Article n'est pas valid {}",dto);
            throw new InvalidEntityException("le mouvement du stock n'est pas valid", ErrorCodes.Stock_NOT_VALID,errors);
        }
        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue())
                )
        );
        dto.setTypeMvt(typeMvtStock);
        return StockDto.fromEntity(
                stockRepository.save(StockDto.toEntity(dto))
        );
    }

    private StockDto sortieNegative(StockDto dto ,TypeMvtStock typeMvtStock){
        List<String> errors= StockValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Article n'est pas valid {}",dto);
            throw new InvalidEntityException("le mouvement du stock n'est pas valid", ErrorCodes.Stock_NOT_VALID,errors);
        }
        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue())* -1
                )
        );
        dto.setTypeMvt(typeMvtStock);
        return StockDto.fromEntity(
                stockRepository.save(StockDto.toEntity(dto))
        );
    }
}
