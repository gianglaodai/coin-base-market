package leo.prj.petrocoin.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.TransactionDTO;
import leo.prj.petrocoin.bean.dto.TransactionStatus;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionManager;
import leo.prj.petrocoin.service.converter.TransactionConverter;

@Service
public class TransactionService {
	@Autowired
	private TransactionManager transactions;

	@Autowired
	private TransactionConverter transactionConverter;

	public TransactionDTO create(TransactionDTO transaction) {
		return this.transactionConverter.createTransaction(
				this.transactions.persist(this.transactionConverter.createDatabaseTransaction(transaction)));
	}

	public TransactionDTO update(TransactionDTO transaction) {
		return this.transactionConverter.createTransaction(
				this.transactions.persist(this.transactionConverter.createUpdateDatabaseTransaction(transaction)));
	}

	public Optional<TransactionDTO> read(BigInteger id) {
		final Optional<Transaction> foundTransaction = this.transactions.stream().filter(Transaction.ID.equal(id))
				.findFirst();
		if (foundTransaction.isPresent()) {
			return Optional.of(this.transactionConverter.createTransaction(foundTransaction.get()));
		}
		return Optional.empty();
	}

	public void delete(BigInteger id) {
		this.transactions.stream().filter(Transaction.ID.equal(id)).forEach(this.transactions.remover());
	}

	public List<TransactionDTO> getAvailableTransaction(long userId) {
		return this.transactions.stream()
				.filter(transaction -> transaction.getStatus().orElse(TransactionStatus.NEW.name())
						.equals(TransactionStatus.NEW.name()) && transaction.getFkUserFrom().getAsLong() != userId)
				.map(transaction -> this.transactionConverter.createTransaction(transaction))
				.collect(Collectors.toList());
	}

	public List<TransactionDTO> getTransactionsOfUser(long userId) {
		return this.transactions.stream()
				.filter(transaction -> transaction.getStatus().get().equals(TransactionStatus.NEW.name())
						|| transaction.getStatus().get().equals(TransactionStatus.ORDERED.name()))
				.filter(transaction -> transaction.getFkUserFrom().getAsLong() == userId
						|| transaction.getFkUserTo().getAsLong() == userId)
				.map(transaction -> this.transactionConverter.createTransaction(transaction))
				.collect(Collectors.toList());
	}
}
