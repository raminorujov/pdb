package az.pdb.userstock;


import az.pdb.userstock.controller.UserStockController;
import az.pdb.userstock.domain.Transaction;
import az.pdb.userstock.repository.TransactionRepository;
import az.pdb.userstock.service.TransactionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserStockController.class)
public class UserStockControllerTest {

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private MockMvc mockMvc;

    private List<Transaction> transactions;

    @BeforeEach
    public void setUp() {
        String username = "raminorujov@gmail.com";
        String account = "ACC1234567890";

        Transaction transaction1 = new Transaction();
        transaction1.setUserName(username);
        transaction1.setAccountNo(account);
        transaction1.setAmount(BigDecimal.valueOf(1000));
        transaction1.setDate(LocalDateTime.of(2020, Month.OCTOBER, 6, 12, 0, 0));
        transaction1.setDescription("happy birthday gift");
        transactions.add(transaction1);

        Transaction transaction2 = new Transaction();
        transaction2.setUserName(username);
        transaction2.setAccountNo(account);
        transaction2.setAmount(BigDecimal.valueOf(500));
        transaction2.setDate(LocalDateTime.of(2020, Month.OCTOBER, 6, 12, 0, 0));
        transaction2.setDescription("happy birthday gift 2");
        transactions.add(transaction2);
    }

    @AfterEach
    public void tearDown() {
        this.transactions = null;
    }


    @Test
    public void testGetUserTransactions() throws Exception {
        String username = "raminorujov@gmail.com";
        List<Transaction> transactionList = transactionService.getUserTransactions(username);

        Mockito.when(transactionService.getUserTransactions(username)).thenReturn(transactions);

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());

        Mockito.verify(transactionService, times(1)).getUserTransactions(username);
        Mockito.verifyNoMoreInteractions(transactionService);
    }

}
