package leo.prj.petrocoin.service.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.common.CommonConstant;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.Transaction;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionImpl;

@Component
public class TransactionConverter {
	public Transaction createDatabaseTransaction(leo.prj.petrocoin.bean.backobject.Transaction transaction) {
		return new TransactionImpl().setAmount(transaction.getAmount()).setContent(transaction.getContent())
				.setCreatedDate(new Timestamp(transaction.getCreatedDate().getTime()))
				.setExecutionDate(new Timestamp(transaction.getExecutionDate().getTime()))
				.setFkCurrency(transaction.getFkCurrency()).setFkUserFrom(transaction.getFkUserFrom())
				.setFkUserTo(transaction.getFkUserTo());
	}

	public Transaction createUpdateDatabaseTransaction(leo.prj.petrocoin.bean.backobject.Transaction transaction) {
		return this.createDatabaseTransaction(transaction).setId(transaction.getId());
	}

	public leo.prj.petrocoin.bean.backobject.Transaction createTransaction(Transaction transaction) {
		final leo.prj.petrocoin.bean.backobject.Transaction transactionBean = new leo.prj.petrocoin.bean.backobject.Transaction();
		transactionBean.setId(transaction.getId());
		transactionBean.setAmount(transaction.getAmount().orElse(0));
		transactionBean.setContent(transaction.getContent().orElse(CommonConstant.EMPTY));
		transactionBean.setCreatedDate(
				new Date(transaction.getCreatedDate().orElse(new Timestamp(new Date().getTime())).getTime()));
		transaction.getExecutionDate().ifPresent(date -> transactionBean.setExecutionDate(new Date(date.getTime())));
		transactionBean.setFkCurrency(transaction.getFkCurrency().getAsLong());
		transactionBean.setFkUserFrom(transaction.getFkUserFrom().getAsLong());
		transactionBean.setFkUserTo(transaction.getFkUserTo().getAsLong());
		transactionBean.setStatus(transaction.getStatus().orElse(CommonConstant.EMPTY));
		return transactionBean;
	}
}
