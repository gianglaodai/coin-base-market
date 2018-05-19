package leo.prj.petrocoin.service;

import java.math.BigInteger;
import java.util.Optional;

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

	public PetroTransactionDTO create(PetroTransactionDTO petroTransaction) {
		return this.petroTransactionConverter.createPetroTransaction(this.petroTransactions
				.persist(this.petroTransactionConverter.createDatabasePetroTransaction(petroTransaction)));
	}

	public PetroTransactionDTO update(PetroTransactionDTO petroTransaction) {
		return this.petroTransactionConverter.createPetroTransaction(this.petroTransactions
				.persist(this.petroTransactionConverter.createUpdateDatabasePetroTransaction(petroTransaction)));
	}

	public Optional<PetroTransactionDTO> read(BigInteger id) {
		final Optional<PetroTransaction> foundPetroTransaction = this.petroTransactions.stream()
				.filter(PetroTransaction.ID.equal(id)).findFirst();
		if (foundPetroTransaction.isPresent()) {
			return Optional.of(this.petroTransactionConverter.createPetroTransaction(foundPetroTransaction.get()));
		}
		return Optional.empty();
	}

	public void delete(BigInteger id) {
		this.petroTransactions.stream().filter(PetroTransaction.ID.equal(id)).forEach(this.petroTransactions.remover());
	}
}
