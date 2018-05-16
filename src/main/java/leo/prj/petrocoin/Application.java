package leo.prj.petrocoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import leo.prj.petrocoin.db.PetroCoinApplication;
import leo.prj.petrocoin.db.PetroCoinApplicationBuilder;

@SpringBootApplication
@RestController
public class Application {
	private static DB DATABASE;
	static {
		DBConfigurationBuilder dbConfigurationBuilder = DBConfigurationBuilder.newBuilder();
		dbConfigurationBuilder.setPort(3306);
		dbConfigurationBuilder.setDataDir("resources/db");
		try {
			DATABASE = DB.newEmbeddedDB(dbConfigurationBuilder.build());
			DATABASE.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/shutdown")
	public void shutdown() throws Exception {
		DATABASE.stop();
		System.exit(0);
	}

	@Bean
	public PetroCoinApplication petroCoinApplication() {
		return new PetroCoinApplicationBuilder().build();
	}

}
