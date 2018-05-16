package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.backobject.Currency;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencyManager;
import leo.prj.petrocoin.service.converter.CurrencyConverter;

@Service
public class CurrencyService {
	@Autowired
	private CurrencyManager currencies;

	@Autowired
	private CurrencyConverter currencyConverter;

	public Currency create(Currency currency) {
		return currencyConverter.createCurrency(currencies.persist(currencyConverter.createDatabaseCurrency(currency)));
	}

	public Currency update(Currency currency) {
		return currencyConverter
				.createCurrency(currencies.persist(currencyConverter.createUpdateDatabaseCurrency(currency)));
	}

	public Optional<Currency> read(long id) {
		Optional<leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency> foundCurrency = currencies.stream()
				.filter(leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency.ID.equal(id)).findFirst();
		if (foundCurrency.isPresent()) {
			return Optional.of(currencyConverter.createCurrency(foundCurrency.get()));
		}

		return Optional.empty();
	}

	public void delete(long id) {
		currencies.stream().filter(leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency.ID.equal(id))
				.forEach(currencies.remover());
	}
}
