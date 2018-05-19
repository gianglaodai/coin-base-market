package leo.prj.petrocoin.service.converter;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.bean.dto.PetroTransactionDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionImpl;

@Component
public class PetroTransactionConverter {
	public PetroTransaction createDatabasePetroTransaction(
			leo.prj.petrocoin.bean.dto.PetroTransactionDTO petroTransaction) {
		return new PetroTransactionImpl().setAmount(petroTransaction.getAmount())
				.setFkRating(petroTransaction.getFkRating()).setFkWallet(petroTransaction.getFkWallet())
				.setIsBuying(petroTransaction.isBuying() ? 1 : 0);
	}

	public PetroTransaction createUpdateDatabasePetroTransaction(PetroTransactionDTO petroTransaction) {
		return this.createDatabasePetroTransaction(petroTransaction).setId(petroTransaction.getId());
	}

	public PetroTransactionDTO createPetroTransaction(PetroTransaction petroTransaction) {
		final PetroTransactionDTO petroTransactionBean = new PetroTransactionDTO();
		petroTransactionBean.setAmount(petroTransaction.getAmount().getAsDouble());
		petroTransactionBean.setBuying(petroTransaction.getIsBuying().getAsInt() == 0 ? false : true);
		petroTransactionBean.setFkRating(petroTransaction.getFkRating().getAsLong());
		petroTransactionBean.setFkWallet(petroTransaction.getFkWallet().getAsLong());
		petroTransactionBean.setId(petroTransaction.getId());
		return petroTransactionBean;
	}
}
