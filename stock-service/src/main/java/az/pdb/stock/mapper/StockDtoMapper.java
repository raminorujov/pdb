package az.pdb.stock.mapper;

import az.pdb.stock.domain.Stock;
import az.pdb.stock.dto.StockDto;

import java.time.*;

public class StockDtoMapper {

    public static Stock map(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setName(stockDto.getName());
        stock.setSymbol(stockDto.getSymbol());
        stock.setExchange(stockDto.getExchange());
        stock.setPrice(stockDto.getPrice());
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(stockDto.getLastUpdated()), ZoneId.systemDefault());
        stock.setLastUpdated(dateTime);
        return stock;
    }

    public static StockDto map(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setName(stock.getName());
        stockDto.setSymbol(stock.getSymbol());
        stockDto.setExchange(stock.getExchange());
        stockDto.setPrice(stock.getPrice());
        ZonedDateTime zdt = stock.getLastUpdated().atZone(ZoneId.systemDefault());
        stockDto.setLastUpdated(zdt.toInstant().toEpochMilli());
        return stockDto;
    }
}
