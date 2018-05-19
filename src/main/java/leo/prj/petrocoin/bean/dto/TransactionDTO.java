package leo.prj.petrocoin.bean.dto;

import java.math.BigInteger;
import java.util.Date;

import leo.prj.petrocoin.common.CommonConstant;

public class TransactionDTO {
	private BigInteger id;
	private long fkUserFrom;
	private long fkUserTo;
	private long fkCurrency;
	private double amount;
	private String status;
	private String content;
	private Date createdDate;
	private Date executionDate;

	public TransactionDTO() {
		this.id = BigInteger.valueOf(-1);
		this.fkUserFrom = -1;
		this.fkUserTo = -1;
		this.fkCurrency = -1;
		this.amount = 0;
		this.status = CommonConstant.EMPTY;
		this.content = CommonConstant.EMPTY;
		this.createdDate = new Date();
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public long getFkUserFrom() {
		return fkUserFrom;
	}

	public void setFkUserFrom(long fkUserFrom) {
		this.fkUserFrom = fkUserFrom;
	}

	public long getFkUserTo() {
		return fkUserTo;
	}

	public void setFkUserTo(long fkUserTo) {
		this.fkUserTo = fkUserTo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

}
