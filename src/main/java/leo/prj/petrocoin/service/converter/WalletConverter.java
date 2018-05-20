package leo.prj.petrocoin.service.converter;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.bean.dto.WalletDTO;
import leo.prj.petrocoin.common.CommonConstant;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletImpl;

@Component
public class WalletConverter {
	public Wallet createDatabaseWallet(WalletDTO wallet) {
		return new WalletImpl().setAmount(wallet.getAmount()).setFkCurrency(wallet.getFkCurrency())
				.setFkUser(wallet.getFkUser()).setWalletAddress(wallet.getWalletAddress());
	}

	public Wallet createUpdateDatabaseWallet(WalletDTO wallet) {
		return this.createDatabaseWallet(wallet).setId(wallet.getId());
	}

	public WalletDTO createWallet(Wallet wallet) {
		if (wallet == null) {
			return null;
		}
		final WalletDTO walletBean = new WalletDTO();
		walletBean.setAmount(wallet.getAmount().orElse(0));
		walletBean.setFkCurrency(wallet.getFkCurrency().getAsLong());
		walletBean.setFkUser(wallet.getFkUser().getAsLong());
		walletBean.setId(wallet.getId());
		walletBean.setWalletAddress(wallet.getWalletAddress().orElse(CommonConstant.EMPTY));
		return walletBean;
	}
}
