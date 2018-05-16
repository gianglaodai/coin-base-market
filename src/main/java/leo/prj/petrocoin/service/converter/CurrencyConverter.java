package leo.prj.petrocoin.service.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import leo.prj.petrocoin.common.CommonConstant;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencyImpl;

@Component
public class CurrencyConverter {
	public Currency createDatabaseCurrency(leo.prj.petrocoin.bean.backobject.Currency currency) {
		return new CurrencyImpl().setCreatedDate(new Timestamp(currency.getCreatedDate().getTime()))
				.setIsPetroCoin(currency.isPetroCoin() ? 1 : 0).setName(currency.getName())
				.setUpdatedDate(new Timestamp(currency.getUpdatedDate().getTime()));
	}

	public Currency createUpdateDatabaseCurrency(leo.prj.petrocoin.bean.backobject.Currency currency) {
		return this.createDatabaseCurrency(currency).setId(currency.getId());
	}

	public leo.prj.petrocoin.bean.backobject.Currency createCurrency(Currency currency) {
		leo.prj.petrocoin.bean.backobject.Currency currencyBean = new leo.prj.petrocoin.bean.backobject.Currency();
		currencyBean.setCreatedDate(
				new Date(currency.getCreatedDate().orElse(new Timestamp(new Date().getTime())).getTime()));
		currencyBean.setId(currency.getId());
		currencyBean.setName(currency.getName().orElse(CommonConstant.EMPTY));
		currencyBean.setPetroCoin(currency.getIsPetroCoin().getAsInt() == 0 ? false : true);
		currencyBean.setUpdatedDate(
				new Date(currency.getUpdatedDate().orElse(new Timestamp(new Date().getTime())).getTime()));
		return currencyBean;
	}
}
