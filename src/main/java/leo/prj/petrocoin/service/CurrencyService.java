package leo.prj.petrocoin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.prj.petrocoin.bean.dto.CurrencyDTO;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.Currency;
import leo.prj.petrocoin.db.petro_coin.petro_coin.currency.CurrencyManager;
import leo.prj.petrocoin.service.converter.CurrencyConverter;

@Service
public class CurrencyService {
	@Autowired
	private CurrencyManager currencies;

	@Autowired
	private CurrencyConverter currencyConverter;

	public CurrencyDTO create(CurrencyDTO currency) {
		return this.currencyConverter
				.createCurrency(this.currencies.persist(this.currencyConverter.createDatabaseCurrency(currency)));
	}

	public CurrencyDTO update(CurrencyDTO currency) {
		return this.currencyConverter
				.createCurrency(this.currencies.persist(this.currencyConverter.createUpdateDatabaseCurrency(currency)));
	}

	public Optional<CurrencyDTO> read(long id) {
		final Optional<Currency> foundCurrency = this.currencies.stream().filter(Currency.ID.equal(id)).findFirst();
		if (foundCurrency.isPresent()) {
			return Optional.of(this.currencyConverter.createCurrency(foundCurrency.get()));
		}

		return Optional.empty();
	}

	public void delete(long id) {
		this.currencies.stream().filter(Currency.ID.equal(id)).forEach(this.currencies.remover());
	}
}
