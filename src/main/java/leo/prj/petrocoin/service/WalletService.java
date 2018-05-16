package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.backobject.Wallet;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletManager;
import leo.prj.petrocoin.service.converter.WalletConverter;

@Service
public class WalletService {
	@Autowired
	private WalletManager wallets;

	@Autowired
	private WalletConverter walletConverter;

	public Wallet create(Wallet wallet) {
		return walletConverter.createWallet(wallets.persist(walletConverter.createDatabaseWallet(wallet)));
	}

	public Wallet update(Wallet wallet) {
		return walletConverter.createWallet(wallets.persist(walletConverter.createUpdateDatabaseWallet(wallet)));
	}

	public Optional<Wallet> read(long id) {
		Optional<leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet> foundedWallet = wallets.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet.ID.equal(id)).findFirst();
		if (foundedWallet.isPresent()) {
			return Optional.of(walletConverter.createWallet(foundedWallet.get()));
		}
		return Optional.empty();
	}

	public void delete(long id) {
		wallets.stream().filter(leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet.ID.equal(id))
				.forEach(wallets.remover());
	}
}
