package com.mohamed.commerce.Services;

import com.mohamed.commerce.dto.StockDto;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {

    BigDecimal stockReelArticle(Integer Article_ID);

    List<StockDto> stockArticle(Integer Article_ID);

    StockDto entreeStock(StockDto dto);

    StockDto sortieStock(StockDto  dto);

    StockDto correctionStockPos(StockDto dto);

    StockDto correctionStockNeg(StockDto dto);
}
