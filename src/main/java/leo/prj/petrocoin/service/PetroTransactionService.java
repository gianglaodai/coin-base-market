package leo.prj.petrocoin.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.backobject.PetroTransaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionManager;
import leo.prj.petrocoin.service.converter.PetroTransactionConverter;

@Service
public class PetroTransactionService {
	@Autowired
	private PetroTransactionManager petroTransactions;

	@Autowired
	private PetroTransactionConverter petroTransactionConverter;

	public PetroTransaction create(PetroTransaction petroTransaction) {
		return petroTransactionConverter.createPetroTransaction(
				petroTransactions.persist(petroTransactionConverter.createDatabasePetroTransaction(petroTransaction)));
	}

	public PetroTransaction update(PetroTransaction petroTransaction) {
		return petroTransactionConverter.createPetroTransaction(petroTransactions
				.persist(petroTransactionConverter.createUpdateDatabasePetroTransaction(petroTransaction)));
	}

	public Optional<PetroTransaction> read(BigInteger id) {
		Optional<leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransaction> foundPetroTransaction = petroTransactions
				.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransaction.ID.equal(id))
				.findFirst();
		if (foundPetroTransaction.isPresent()) {
			return Optional.of(petroTransactionConverter.createPetroTransaction(foundPetroTransaction.get()));
		}
		return Optional.empty();
	}

	public void delete(BigInteger id) {
		this.petroTransactions.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransaction.ID.equal(id))
				.forEach(petroTransactions.remover());
	}
}
