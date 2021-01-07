package hepl.sysdist.labo.tva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
@EnableEurekaClient
public class TvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvaApplication.class, args);
	}

	@Bean
	public HashMap<String, Float> getTvaAll()
	{
		HashMap<String, Float> tva = new HashMap<>();
		tva.put("book", 0.06f);
		tva.put("other", 0.21f);
		return tva;
	}

}
