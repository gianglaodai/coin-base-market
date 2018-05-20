package leo.prj.petrocoin.service.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.bean.dto.DepositHistoryDTO;
import leo.prj.petrocoin.common.CommonConstant;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistoryImpl;

@Component
public class DepositHistoryConverter {

	public DepositHistory createDatabaseDepositHistory(DepositHistoryDTO depositHistory) {
		return new DepositHistoryImpl().setAmount(depositHistory.getAmount())
				.setDepositDate(new Timestamp(depositHistory.getDepositDate().getTime()))
				.setFkWallet(depositHistory.getFkWallet()).setCbTransactionId(depositHistory.getCbTransactionId());
	}

	public DepositHistory createUpdateDepositHistory(DepositHistoryDTO depositHistory) {
		return this.createDatabaseDepositHistory(depositHistory).setId(depositHistory.getId());
	}

	public DepositHistoryDTO createDepositHistory(DepositHistory depositHistory) {
		final DepositHistoryDTO depositHistoryBean = new DepositHistoryDTO();
		depositHistoryBean.setAmount(depositHistory.getAmount().getAsDouble());
		depositHistoryBean.setDepositDate(
				new Date(depositHistory.getDepositDate().orElse(new Timestamp(new Date().getTime())).getTime()));
		depositHistoryBean.setFkWallet(depositHistory.getFkWallet().getAsLong());
		depositHistoryBean.setId(depositHistory.getId());
		depositHistoryBean.setCbTransactionId(depositHistory.getCbTransactionId().orElse(CommonConstant.EMPTY));
		return depositHistoryBean;
	}
}
