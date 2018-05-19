package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.DepositHistoryDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory;
import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistoryManager;
import leo.prj.petrocoin.service.converter.DepositHistoryConverter;

@Service
public class DepositHistoryService {

	@Autowired
	private DepositHistoryManager depositHistories;

	@Autowired
	private DepositHistoryConverter depositHistoryConverter;

	public DepositHistoryDTO create(DepositHistoryDTO depositHistory) {
		return this.depositHistoryConverter.createDepositHistory(this.depositHistories
				.persist(this.depositHistoryConverter.createDatabaseDepositHistory(depositHistory)));
	}

	public DepositHistoryDTO update(DepositHistoryDTO depositHistory) {
		return this.depositHistoryConverter.createDepositHistory(
				this.depositHistories.persist(this.depositHistoryConverter.createUpdateDepositHistory(depositHistory)));
	}

	public Optional<DepositHistoryDTO> read(int id) {
		final Optional<DepositHistory> foundDepositHistory = this.depositHistories.stream()
				.filter(DepositHistory.ID.equal(id)).findFirst();
		if (foundDepositHistory.isPresent()) {
			return Optional.of(this.depositHistoryConverter.createDepositHistory(foundDepositHistory.get()));
		}
		return Optional.empty();
	}

	public void delete(int id) {
		this.depositHistories.stream().filter(DepositHistory.ID.equal(id)).forEach(this.depositHistories.remover());
	}
}
