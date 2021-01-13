package hepl.sysdist.labo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootApplication
@EnableEurekaClient
public class ApiApplication
{
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public HashMap<String, Integer> getUsersId()
	{
		HashMap<String, Integer> hashmap = new HashMap<>();
		hashmap.put("loic", 1);
		hashmap.put("samuel", 2);
		hashmap.put("kevin", 3);
		return hashmap;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
