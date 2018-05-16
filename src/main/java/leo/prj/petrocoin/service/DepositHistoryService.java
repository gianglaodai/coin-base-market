package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.backobject.DepositHistory;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistoryManager;
import leo.prj.petrocoin.service.converter.DepositHistoryConverter;

@Service
public class DepositHistoryService {

	@Autowired
	private DepositHistoryManager depositHistories;

	@Autowired
	private DepositHistoryConverter depositHistoryConverter;

	public DepositHistory create(DepositHistory depositHistory) {
		return depositHistoryConverter.createDepositHistory(
				depositHistories.persist(depositHistoryConverter.createDatabaseDepositHistory(depositHistory)));
	}

	public DepositHistory update(DepositHistory depositHistory) {
		return depositHistoryConverter.createDepositHistory(
				depositHistories.persist(depositHistoryConverter.createUpdateDepositHistory(depositHistory)));
	}

	public Optional<DepositHistory> read(int id) {
		Optional<leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory> foundDepositHistory = depositHistories
				.stream().filter(leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory.ID.equal(id))
				.findFirst();
		if (foundDepositHistory.isPresent()) {
			return Optional.of(depositHistoryConverter.createDepositHistory(foundDepositHistory.get()));
		}
		return Optional.empty();
	}

	public void delete(int id) {
		depositHistories.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory.ID.equal(id))
				.forEach(depositHistories.remover());
	}
}
