package leo.prj.petrocoin.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.backobject.Transaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionManager;
import leo.prj.petrocoin.service.converter.TransactionConverter;

@Service
public class TransactionService {
	@Autowired
	private TransactionManager transactions;

	@Autowired
	private TransactionConverter transactionConverter;

	public Transaction create(Transaction transaction) {
		return transactionConverter
				.createTransaction(transactions.persist(transactionConverter.createDatabaseTransaction(transaction)));
	}

	public Transaction update(Transaction transaction) {
		return transactionConverter.createTransaction(
				transactions.persist(transactionConverter.createUpdateDatabaseTransaction(transaction)));
	}

	public Optional<Transaction> read(BigInteger id) {
		Optional<leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction> foundTransaction = transactions
				.stream().filter(leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction.ID.equal(id))
				.findFirst();
		if (foundTransaction.isPresent()) {
			return Optional.of(transactionConverter.createTransaction(foundTransaction.get()));
		}
		return Optional.empty();
	}

	public void delete(BigInteger id) {
		this.transactions.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction.ID.equal(id))
				.forEach(transactions.remover());
	}
}
