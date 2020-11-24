package az.pdb.userstock.service;

import az.pdb.userstock.domain.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getUserTransactions(String username);
}
