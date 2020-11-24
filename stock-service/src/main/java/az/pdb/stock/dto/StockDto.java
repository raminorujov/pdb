package az.pdb.stock.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private String exchange;
    private String symbol;
    private String name;
    private BigDecimal price;
    private long lastUpdated;
}
