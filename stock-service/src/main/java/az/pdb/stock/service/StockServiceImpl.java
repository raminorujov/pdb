package az.pdb.stock.service;

import az.pdb.stock.domain.Stock;
import az.pdb.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getStockList() {
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getStockList(String exchange) {
        return stockRepository.findAllByExchange(exchange);
    }

    @Override
    public Optional<Stock> getStock(String symbol) {
        return stockRepository.findBySymbol(symbol);
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }
}
