package leo.prj.petrocoin.bean.dto;

import java.util.Date;

public class DepositHistoryDTO {
	private int id;
	private long fkWallet;
	private Date depositDate;
	private double amount;

	public DepositHistoryDTO() {
		this.id = -1;
		this.fkWallet = -1;
		this.depositDate = new Date();
		this.amount = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getFkWallet() {
		return fkWallet;
	}

	public void setFkWallet(long fkWallet) {
		this.fkWallet = fkWallet;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
