package az.pdb.userstock.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    private Long id;
    private String userName;
    private String accountNo;
    private BigDecimal amount;
    private String description;
    private LocalDateTime date;

}
