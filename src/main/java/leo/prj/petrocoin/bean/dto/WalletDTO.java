package leo.prj.petrocoin.bean.dto;

import leo.prj.petrocoin.common.CommonConstant;

public class WalletDTO {
	private long id;
	private long fkUser;
	private long fkCurrency;
	private double amount;
	private String walletAddress;

	public WalletDTO() {
		this.id = -1;
		this.fkUser = -1;
		this.fkCurrency = -1;
		this.amount = 0;
		this.walletAddress = CommonConstant.EMPTY;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFkUser() {
		return fkUser;
	}

	public void setFkUser(long fkUser) {
		this.fkUser = fkUser;
	}

	public long getFkCurrency() {
		return fkCurrency;
	}

	public void setFkCurrency(long fkCurrency) {
		this.fkCurrency = fkCurrency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}
}
