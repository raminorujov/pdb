package az.pdb.stock.repository;

import az.pdb.stock.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    List<Stock> findAll();
    List<Stock> findAllByExchange(String exchange);
    Optional<Stock> findBySymbol(String symbol);
}
