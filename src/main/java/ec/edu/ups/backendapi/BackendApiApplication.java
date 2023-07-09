package ec.edu.ups.backendapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendApiApplication implements WebMvcConfigurer {

	
	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

}
