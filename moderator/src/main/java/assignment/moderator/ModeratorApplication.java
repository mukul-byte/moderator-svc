package assignment.moderator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ModeratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeratorApplication.class, args);
	}

}