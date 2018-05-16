package leo.prj.petrocoin.service.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.Rating;
import leo.prj.petrocoin.db.petro_coin.petro_coin.rating.RatingImpl;

@Component
public class RatingConverter {
	public Rating createDatabaseRating(leo.prj.petrocoin.bean.backobject.Rating rating) {
		return new RatingImpl().setBuyRating(rating.getBuyRating())
				.setCreatedDate(new Timestamp(rating.getCreatedDate().getTime()))
				.setFkCurrencyFrom(rating.getFkCurrencyFrom()).setFkCurrencyTo(rating.getFkCurrencyTo())
				.setSellRating(rating.getSellRating());
	}

	public Rating createUpdateDatabaseRating(leo.prj.petrocoin.bean.backobject.Rating rating) {
		return this.createDatabaseRating(rating).setId(rating.getId());
	}

	public leo.prj.petrocoin.bean.backobject.Rating createRating(Rating rating) {
		leo.prj.petrocoin.bean.backobject.Rating ratingBean = new leo.prj.petrocoin.bean.backobject.Rating();
		ratingBean.setBuyRating(rating.getBuyRating().getAsDouble());
		ratingBean.setCreatedDate(
				new Date(rating.getCreatedDate().orElse(new Timestamp(new Date().getTime())).getTime()));
		ratingBean.setFkCurrencyFrom(rating.getFkCurrencyFrom().getAsLong());
		ratingBean.setFkCurrencyTo(rating.getFkCurrencyTo().getAsLong());
		ratingBean.setId(rating.getId());
		ratingBean.setSellRating(rating.getSellRating().getAsDouble());
		return ratingBean;
	}
}
