package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query("SELECT sum(S.quantite) from  Stock S where S.article.id=:Article_ID")
    BigDecimal stockReelArticle(@Param("Article_ID") Integer Article_ID);

    List<Stock> findAllByArticleId(Integer Article_ID);
}
