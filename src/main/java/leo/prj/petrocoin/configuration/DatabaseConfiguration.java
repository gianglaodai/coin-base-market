package leo.prj.petrocoin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.petro_coin.PetroCoinApplication;
import com.company.petro_coin.petro_coin.petro_coin.user.UserManager;

@Configuration
public class DatabaseConfiguration {
	@Autowired
	private PetroCoinApplication petroCoinApplication;

	@Bean
	public UserManager users() {
		return petroCoinApplication.getOrThrow(UserManager.class);
	}
}
