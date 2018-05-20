package leo.prj.petrocoin.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.PetroTransactionDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionManager;
import leo.prj.petrocoin.service.converter.PetroTransactionConverter;

@Service
public class PetroTransactionService {
	@Autowired
	private PetroTransactionManager petroTransactions;

	@Autowired
	private PetroTransactionConverter petroTransactionConverter;

	private Function<PetroTransaction, PetroTransactionDTO> mapper = petroTransaction -> this.petroTransactionConverter
			.createPetroTransaction(petroTransaction);

	public PetroTransactionDTO create(PetroTransactionDTO petroTransaction) {
		return this.petroTransactionConverter.createPetroTransaction(this.petroTransactions
				.persist(this.petroTransactionConverter.createDatabasePetroTransaction(petroTransaction)));
	}

	public PetroTransactionDTO update(PetroTransactionDTO petroTransaction) {
		return this.petroTransactionConverter.createPetroTransaction(this.petroTransactions
				.persist(this.petroTransactionConverter.createUpdateDatabasePetroTransaction(petroTransaction)));
	}

	public Optional<PetroTransactionDTO> read(BigInteger id) {
		return this.petroTransactions.stream().filter(PetroTransaction.ID.equal(id)).map(mapper).findFirst();
	}

	public void delete(BigInteger id) {
		this.petroTransactions.stream().filter(PetroTransaction.ID.equal(id)).forEach(this.petroTransactions.remover());
	}

	public List<PetroTransactionDTO> getAll() {
		return this.petroTransactions.stream().map(mapper).collect(Collectors.toList());
	}
}
