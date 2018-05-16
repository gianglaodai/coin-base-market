package leo.prj.petrocoin.service.converter;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionImpl;

@Component
public class PetroTransactionConverter {
	public PetroTransaction createDatabasePetroTransaction(
			leo.prj.petrocoin.bean.backobject.PetroTransaction petroTransaction) {
		return new PetroTransactionImpl().setAmount(petroTransaction.getAmount())
				.setFkRating(petroTransaction.getFkRating()).setFkWallet(petroTransaction.getFkWallet())
				.setIsBuying(petroTransaction.isBuying() ? 1 : 0);
	}

	public PetroTransaction createUpdateDatabasePetroTransaction(
			leo.prj.petrocoin.bean.backobject.PetroTransaction petroTransaction) {
		return this.createDatabasePetroTransaction(petroTransaction).setId(petroTransaction.getId());
	}

	public leo.prj.petrocoin.bean.backobject.PetroTransaction createPetroTransaction(
			PetroTransaction petroTransaction) {
		leo.prj.petrocoin.bean.backobject.PetroTransaction petroTransactionBean = new leo.prj.petrocoin.bean.backobject.PetroTransaction();
		petroTransactionBean.setAmount(petroTransaction.getAmount().getAsDouble());
		petroTransactionBean.setBuying(petroTransaction.getIsBuying().getAsInt() == 0 ? false : true);
		petroTransactionBean.setFkRating(petroTransaction.getFkRating().getAsLong());
		petroTransactionBean.setFkWallet(petroTransaction.getFkWallet().getAsLong());
		petroTransactionBean.setId(petroTransaction.getId());
		return petroTransactionBean;
	}
}
