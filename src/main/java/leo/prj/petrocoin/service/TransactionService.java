package leo.prj.petrocoin.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
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

	private Function<Transaction, TransactionDTO> mapper = transaction -> this.transactionConverter
			.createTransaction(transaction);

	public TransactionDTO create(TransactionDTO transaction) {
		return this.transactionConverter.createTransaction(
				this.transactions.persist(this.transactionConverter.createDatabaseTransaction(transaction)));
	}

	public TransactionDTO update(TransactionDTO transaction) {
		return this.transactionConverter.createTransaction(
				this.transactions.persist(this.transactionConverter.createUpdateDatabaseTransaction(transaction)));
	}

	public Optional<TransactionDTO> read(BigInteger id) {
		return this.transactions.stream().filter(Transaction.ID.equal(id)).map(mapper).findFirst();
	}

	public void delete(BigInteger id) {
		this.transactions.stream().filter(Transaction.ID.equal(id)).forEach(this.transactions.remover());
	}

	public List<TransactionDTO> getAvailableTransaction(long userId) {
		return this.getTransactions(transaction -> transaction.getStatus().orElse(TransactionStatus.NEW.name())
				.equals(TransactionStatus.NEW.name()) && transaction.getFkUserFrom().orElse(-1) != userId);
	}

	public List<TransactionDTO> getTransactionsOfUser(long userId) {
		return this.getTransactions(transaction -> (transaction.getStatus().get().equals(TransactionStatus.NEW.name())
				|| transaction.getStatus().get().equals(TransactionStatus.ORDERED.name()))
				&& (transaction.getFkUserFrom().orElse(-1) == userId
						|| transaction.getFkUserTo().orElse(-1) == userId));
	}

	public List<TransactionDTO> getAll() {
		return this.getTransactions(transaction -> true);
	}

	private List<TransactionDTO> getTransactions(Predicate<? super Transaction> predicate) {
		return this.transactions.stream().filter(predicate).map(mapper).collect(Collectors.toList());
	}
}
