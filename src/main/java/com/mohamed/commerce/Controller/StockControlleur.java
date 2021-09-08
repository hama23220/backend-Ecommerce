package com.mohamed.commerce.Controller;

import com.mohamed.commerce.Controller.Api.StockApi;
import com.mohamed.commerce.Services.StockService;
import com.mohamed.commerce.dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class StockControlleur implements StockApi {

    private StockService stockService;

    @Autowired
    public StockControlleur(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public BigDecimal stockReelArticle(Integer Article_ID) {
        return stockService.stockReelArticle(Article_ID);
    }

    @Override
    public List<StockDto> stockArticle(Integer Article_ID) {
        return stockService.stockArticle(Article_ID);
    }

    @Override
    public StockDto entreeStock(StockDto dto) {
        return stockService.entreeStock(dto);
    }

    @Override
    public StockDto sortieStock(StockDto dto) {
        return stockService.sortieStock(dto);
    }

    @Override
    public StockDto correctionStockPos(StockDto dto) {
        return stockService.correctionStockPos(dto);
    }

    @Override
    public StockDto correctionStockNeg(StockDto dto) {
        return stockService.correctionStockNeg(dto);
    }
}
