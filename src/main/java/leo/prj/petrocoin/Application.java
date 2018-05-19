package leo.prj.petrocoin;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
		final DBConfigurationBuilder dbConfigurationBuilder = DBConfigurationBuilder.newBuilder();
		dbConfigurationBuilder.setPort(3306);
		dbConfigurationBuilder.setDataDir("resources/db");
		try {
			DATABASE = DB.newEmbeddedDB(dbConfigurationBuilder.build());
			DATABASE.start();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		final Scanner sc = new Scanner(System.in);
		boolean shutdown = false;
		while (!shutdown) {
			System.out.print("Shutdown? ");
			shutdown = sc.nextBoolean();
		}
		sc.close();
		DATABASE.stop();
		System.exit(0);
	}

	@Bean
	public PetroCoinApplication petroCoinApplication() {
		return new PetroCoinApplicationBuilder().build();
	}

}
