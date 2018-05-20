package leo.prj.petrocoin.bean.dto;

import java.util.Date;

import leo.prj.petrocoin.common.CommonConstant;

public class DepositHistoryDTO {
	private long id;
	private long fkWallet;
	private Date depositDate;
	private double amount;
	private String cbTransactionId;

	public DepositHistoryDTO() {
		this.id = -1;
		this.fkWallet = -1;
		this.depositDate = new Date();
		this.amount = 0;
		this.cbTransactionId = CommonConstant.EMPTY;
	}

	public String getCbTransactionId() {
		return cbTransactionId;
	}

	public void setCbTransactionId(String cbTransactionId) {
		this.cbTransactionId = cbTransactionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
