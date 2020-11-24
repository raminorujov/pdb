package az.pdb.userstock.service;

import az.pdb.userstock.domain.Transaction;
import az.pdb.userstock.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getUserTransactions(String username) {
        return transactionRepository.findAllByUserNameOrderByDate(username);
    }
}
