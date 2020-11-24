package az.pdb.userstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserStockApplication.class, args);
	}

}
