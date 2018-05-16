package leo.prj.petrocoin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import leo.prj.petrocoin.db.PetroCoinApplication;
import leo.prj.petrocoin.db.petro_coin.petro_coin.user.UserManager;

@Configuration
public class DatabaseConfiguration {
	@Autowired
	private PetroCoinApplication petroCoinApplication;

	@Bean
	public UserManager users() {
		return petroCoinApplication.getOrThrow(UserManager.class);
	}
}
