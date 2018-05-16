package leo.prj.petrocoin.service.converter;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.common.CommonConstant;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletImpl;

@Component
public class WalletConverter {
	public Wallet createDatabaseWallet(leo.prj.petrocoin.bean.backobject.Wallet wallet) {
		return new WalletImpl().setAmount(wallet.getAmount()).setFkCurrency(wallet.getFkCurrency())
				.setFkUser(wallet.getFkUser()).setWalletAddress(wallet.getWalletAddress());
	}

	public Wallet createUpdateDatabaseWallet(leo.prj.petrocoin.bean.backobject.Wallet wallet) {
		return this.createDatabaseWallet(wallet).setId(wallet.getId());
	}

	public leo.prj.petrocoin.bean.backobject.Wallet createWallet(Wallet wallet) {
		if (wallet == null) {
			return null;
		}
		leo.prj.petrocoin.bean.backobject.Wallet walletBean = new leo.prj.petrocoin.bean.backobject.Wallet();
		walletBean.setAmount(wallet.getAmount().orElse(0));
		walletBean.setFkCurrency(wallet.getFkCurrency());
		walletBean.setFkUser(wallet.getFkUser());
		walletBean.setId(wallet.getId());
		walletBean.setWalletAddress(wallet.getWalletAddress().orElse(CommonConstant.EMPTY));
		return walletBean;
	}
}
