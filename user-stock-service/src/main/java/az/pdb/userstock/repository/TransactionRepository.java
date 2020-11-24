package az.pdb.userstock.repository;

import az.pdb.userstock.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByUserNameOrderByDate(String userName);
}
