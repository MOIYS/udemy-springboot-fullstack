package MOIYS.project.learn_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

}
