package leo.prj.petrocoin;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import leo.prj.petrocoin.db.PetroCoinApplication;
import leo.prj.petrocoin.db.PetroCoinApplicationBuilder;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		final Scanner sc = new Scanner(System.in);
		boolean shutdown = false;
		while (!shutdown) {
			System.out.print("Shutdown? ");
			shutdown = sc.nextBoolean();
		}
		sc.close();
		System.exit(0);
	}

	@Bean
	public PetroCoinApplication petroCoinApplication() {
		return new PetroCoinApplicationBuilder().withPort(dbPort).build();
	}

	@Value("${db.port}")
	private int dbPort;
}
