package cz.strazovan.edu.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class RabbitmqApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
