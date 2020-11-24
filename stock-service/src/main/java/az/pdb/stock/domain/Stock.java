package az.pdb.stock.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    private Long id;
    private String exchange;
    private String symbol;
    private String name;
    private BigDecimal price;
    private LocalDateTime lastUpdated;
}
