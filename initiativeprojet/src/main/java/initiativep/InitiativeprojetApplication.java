package initiativep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "initiativep.repository.jpa")
@EnableMongoRepositories(basePackages = "initiativep.repository.mongo")
public class InitiativeprojetApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitiativeprojetApplication.class, args);
	}

}
