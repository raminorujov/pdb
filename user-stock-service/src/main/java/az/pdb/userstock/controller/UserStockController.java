package az.pdb.userstock.controller;

import az.pdb.userstock.domain.Transaction;
import az.pdb.userstock.service.TransactionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-stock")
public class UserStockController {

    private TransactionService transactionService;

    public UserStockController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public List<Transaction> getUserTransactions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return transactionService.getUserTransactions(authentication.getName());
    }
}
