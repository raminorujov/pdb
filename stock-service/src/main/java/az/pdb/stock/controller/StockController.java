package az.pdb.stock.controller;

import az.pdb.stock.domain.Stock;
import az.pdb.stock.dto.StockDto;
import az.pdb.stock.mapper.StockDtoMapper;
import az.pdb.stock.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/")
    public List<StockDto> getStockList() {
        return stockService.getStockList()
                .stream()
                .map(StockDtoMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/exchange/{exchange}")
    public List<StockDto> getStockListByExchange(@PathVariable(name = "exchange") String exchange) {
        return stockService.getStockList(exchange)
                .stream()
                .map(StockDtoMapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/{symbol}")
    public StockDto getStock(@PathVariable(name = "symbol") String symbol) {
        Optional<Stock> optionalStock = stockService.getStock(symbol);
        if(optionalStock.isPresent()) {
            return StockDtoMapper.map(optionalStock.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock symbol " + symbol + " not found");
        }
    }


    @PutMapping()
    public StockDto save(@RequestBody StockDto stockDto) {
        stockService.save(StockDtoMapper.map(stockDto));
        return stockDto;
    }
}
