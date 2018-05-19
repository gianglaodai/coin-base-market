package leo.prj.petrocoin.bean.dto;

import java.util.Date;

import leo.prj.petrocoin.common.CommonConstant;

public class CurrencyDTO {
	private long id;
	private String name;
	private boolean isPetroCoin;
	private Date createdDate;
	private Date updatedDate;

	public CurrencyDTO() {
		this.id = -1;
		this.name = CommonConstant.EMPTY;
		this.isPetroCoin = false;
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPetroCoin() {
		return isPetroCoin;
	}

	public void setPetroCoin(boolean isPetroCoin) {
		this.isPetroCoin = isPetroCoin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
