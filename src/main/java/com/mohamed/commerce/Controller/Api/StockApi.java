package com.mohamed.commerce.Controller.Api;

import com.mohamed.commerce.dto.StockDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

import static com.mohamed.commerce.Utils.Constants.APP_ROOT;

@Api("stock")
public interface StockApi {

    @GetMapping(APP_ROOT + "/stock/stockreel/{Article_ID}")
    BigDecimal stockReelArticle(@PathVariable("Article_ID")Integer Article_ID);

    @GetMapping(APP_ROOT + "/stock/filter/article/{Article_ID}")
    List<StockDto> stockArticle(@PathVariable("Article_ID") Integer Article_ID);

    @PostMapping(APP_ROOT + "/stock/entree")
    StockDto entreeStock(@RequestBody StockDto dto);

    @PostMapping(APP_ROOT + "/stock/sortie")
    StockDto sortieStock( @RequestBody StockDto  dto);

    @PostMapping(APP_ROOT + "/stock/correctionPos")
    StockDto correctionStockPos(@RequestBody StockDto dto);

    @PostMapping(APP_ROOT + "/stock/correctionNeg")
    StockDto correctionStockNeg(@RequestBody StockDto dto);
}
