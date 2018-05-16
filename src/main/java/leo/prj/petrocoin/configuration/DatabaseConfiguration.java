package leo.prj.petrocoin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import leo.prj.petrocoin.db.PetroCoinApplication;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencyManager;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistoryManager;
import leo.prj.petrocoin.db.petro_coin.petro_coin.petro_transaction.PetroTransactionManager;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.RatingManager;
import leo.prj.petrocoin.db.petro_coin.petro_coin.transaction.TransactionManager;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserManager;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletManager;

@Configuration
public class DatabaseConfiguration {
	@Autowired
	private PetroCoinApplication petroCoinApplication;

	@Bean
	public UserManager users() {
		return petroCoinApplication.getOrThrow(UserManager.class);
	}

	@Bean
	public WalletManager wallets() {
		return petroCoinApplication.getOrThrow(WalletManager.class);
	}

	@Bean
	public TransactionManager transactions() {
		return petroCoinApplication.getOrThrow(TransactionManager.class);
	}

	@Bean
	public RatingManager ratings() {
		return petroCoinApplication.getOrThrow(RatingManager.class);
	}

	@Bean
	public PetroTransactionManager petroTransactions() {
		return petroCoinApplication.getOrThrow(PetroTransactionManager.class);
	}

	@Bean
	public DepositHistoryManager depositHistories() {
		return petroCoinApplication.getOrThrow(DepositHistoryManager.class);
	}

	@Bean

	public CurrencyManager currencies() {
		return petroCoinApplication.getOrThrow(CurrencyManager.class);
	}
}
