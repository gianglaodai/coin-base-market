package leo.prj.petrocoin.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	private Function<DepositHistory, DepositHistoryDTO> mapper = depositHistory -> this.depositHistoryConverter
			.createDepositHistory(depositHistory);

	public DepositHistoryDTO create(DepositHistoryDTO depositHistory) {
		return this.depositHistoryConverter.createDepositHistory(this.depositHistories
				.persist(this.depositHistoryConverter.createDatabaseDepositHistory(depositHistory)));
	}

	public DepositHistoryDTO update(DepositHistoryDTO depositHistory) {
		return this.depositHistoryConverter.createDepositHistory(
				this.depositHistories.persist(this.depositHistoryConverter.createUpdateDepositHistory(depositHistory)));
	}

	public Optional<DepositHistoryDTO> read(long id) {
		return this.depositHistories.stream().filter(DepositHistory.ID.equal(id)).map(mapper).findFirst();
	}

	public void delete(long id) {
		this.depositHistories.stream().filter(DepositHistory.ID.equal(id)).forEach(this.depositHistories.remover());
	}

	public List<DepositHistoryDTO> getAll() {
		return this.depositHistories.stream().map(mapper).collect(Collectors.toList());
	}
}
