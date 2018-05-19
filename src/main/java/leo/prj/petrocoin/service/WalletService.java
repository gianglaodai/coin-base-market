package leo.prj.petrocoin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.WalletDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.WalletManager;
import leo.prj.petrocoin.service.converter.WalletConverter;

@Service
public class WalletService {
	@Autowired
	private WalletManager wallets;

	@Autowired
	private WalletConverter walletConverter;

	public WalletDTO create(WalletDTO wallet) {
		return this.walletConverter
				.createWallet(this.wallets.persist(this.walletConverter.createDatabaseWallet(wallet)));
	}

	public WalletDTO update(WalletDTO wallet) {
		return this.walletConverter
				.createWallet(this.wallets.persist(this.walletConverter.createUpdateDatabaseWallet(wallet)));
	}

	public Optional<WalletDTO> read(long id) {
		final Optional<Wallet> foundedWallet = this.wallets.stream().filter(Wallet.ID.equal(id)).findFirst();
		if (foundedWallet.isPresent()) {
			return Optional.of(this.walletConverter.createWallet(foundedWallet.get()));
		}
		return Optional.empty();
	}

	public void delete(long id) {
		this.wallets.stream().filter(Wallet.ID.equal(id)).forEach(this.wallets.remover());
	}

	public List<WalletDTO> getByUserId(long userId) {
		return this.wallets.stream().filter(Wallet.FK_USER.equal(userId)).map(wallet-> this.walletConverter.createWallet(wallet)).collect(Collectors.toList());
	}
}
