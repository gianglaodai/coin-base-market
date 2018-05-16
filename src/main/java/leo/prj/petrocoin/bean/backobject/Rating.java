package leo.prj.petrocoin.bean.backobject;

import java.util.Date;

public class Rating {
	private long id;
	private long fkCurrencyFrom;
	private long fkCurrencyTo;
	private double sellRating;
	private double buyRating;
	private Date createdDate;

	public Rating() {
		this.id = -1;
		this.fkCurrencyFrom = -1;
		this.fkCurrencyTo = -1;
		this.sellRating = -1;
		this.buyRating = -1;
		this.createdDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFkCurrencyFrom() {
		return fkCurrencyFrom;
	}

	public void setFkCurrencyFrom(long fkCurrencyFrom) {
		this.fkCurrencyFrom = fkCurrencyFrom;
	}

	public long getFkCurrencyTo() {
		return fkCurrencyTo;
	}

	public void setFkCurrencyTo(long fkCurrencyTo) {
		this.fkCurrencyTo = fkCurrencyTo;
	}

	public double getSellRating() {
		return sellRating;
	}

	public void setSellRating(double sellRating) {
		this.sellRating = sellRating;
	}

	public double getBuyRating() {
		return buyRating;
	}

	public void setBuyRating(double buyRating) {
		this.buyRating = buyRating;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
