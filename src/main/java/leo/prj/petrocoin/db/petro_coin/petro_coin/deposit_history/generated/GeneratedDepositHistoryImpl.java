package leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.generated;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.StringJoiner;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.core.util.OptionalUtil;

import leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory;
import leo.prj.petrocoin.db.petro_coin.petro_coin.wallet.Wallet;

/**
 * The generated base implementation of the
 * {@link leo.prj.petrocoin.db.petro_coin.petro_coin.deposit_history.DepositHistory}-interface.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedDepositHistoryImpl implements DepositHistory {

	private long id;
	private long fkWallet;
	private Timestamp depositDate;
	private Double amount;
	private String cbTransactionId;

	protected GeneratedDepositHistoryImpl() {
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public OptionalLong getFkWallet() {
		return OptionalUtil.ofNullable(fkWallet);
	}

	@Override
	public Optional<Timestamp> getDepositDate() {
		return Optional.ofNullable(depositDate);
	}

	@Override
	public OptionalDouble getAmount() {
		return OptionalUtil.ofNullable(amount);
	}

	@Override
	public Optional<String> getCbTransactionId() {
		return Optional.ofNullable(cbTransactionId);
	}

	@Override
	public DepositHistory setId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public DepositHistory setFkWallet(long fkWallet) {
		this.fkWallet = fkWallet;
		return this;
	}

	@Override
	public DepositHistory setDepositDate(Timestamp depositDate) {
		this.depositDate = depositDate;
		return this;
	}

	@Override
	public DepositHistory setAmount(Double amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public DepositHistory setCbTransactionId(String cbTransactionId) {
		this.cbTransactionId = cbTransactionId;
		return this;
	}

	@Override
	public Optional<Wallet> findFkWallet(Manager<Wallet> foreignManager) {
		if (getFkWallet().isPresent()) {
			return foreignManager.stream().filter(Wallet.ID.equal(getFkWallet().getAsLong())).findAny();
		} else {
			return Optional.empty();
		}
	}

	@Override
	public String toString() {
		final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
		sj.add("id = " + Objects.toString(getId()));
		sj.add("fkWallet = " + Objects.toString(OptionalUtil.unwrap(getFkWallet())));
		sj.add("depositDate = " + Objects.toString(OptionalUtil.unwrap(getDepositDate())));
		sj.add("amount = " + Objects.toString(OptionalUtil.unwrap(getAmount())));
		sj.add("cbTransactionId = " + Objects.toString(OptionalUtil.unwrap(getCbTransactionId())));
		return "DepositHistoryImpl " + sj.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof DepositHistory)) {
			return false;
		}
		final DepositHistory thatDepositHistory = (DepositHistory) that;
		if (this.getId() != thatDepositHistory.getId()) {
			return false;
		}
		if (!Objects.equals(this.getFkWallet(), thatDepositHistory.getFkWallet())) {
			return false;
		}
		if (!Objects.equals(this.getDepositDate(), thatDepositHistory.getDepositDate())) {
			return false;
		}
		if (!Objects.equals(this.getAmount(), thatDepositHistory.getAmount())) {
			return false;
		}
		if (!Objects.equals(this.getCbTransactionId(), thatDepositHistory.getCbTransactionId())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + Long.hashCode(getId());
		hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getFkWallet()));
		hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getDepositDate()));
		hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getAmount()));
		hash = 31 * hash + Objects.hashCode(OptionalUtil.unwrap(getCbTransactionId()));
		return hash;
	}
}