package az.pdb.stock.service;

import az.pdb.stock.domain.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    List<Stock> getStockList();
    List<Stock> getStockList(String exchange);
    Optional<Stock> getStock(String symbol);
    Stock save(Stock stock);
}
