package leo.prj.petrocoin.bean.backobject;

import java.math.BigInteger;

public class PetroTransaction {
	private BigInteger id;
	private long fkWallet;
	private long fkRating;
	private double amount;
	private boolean isBuying;

	public PetroTransaction() {
		this.id = BigInteger.valueOf(-1);
		this.fkWallet = -1;
		this.fkRating = -1;
		this.amount = 0;
		this.isBuying = false;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public long getFkWallet() {
		return fkWallet;
	}

	public void setFkWallet(long fkWallet) {
		this.fkWallet = fkWallet;
	}

	public long getFkRating() {
		return fkRating;
	}

	public void setFkRating(long fkRating) {
		this.fkRating = fkRating;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isBuying() {
		return isBuying;
	}

	public void setBuying(boolean isBuying) {
		this.isBuying = isBuying;
	}
}
