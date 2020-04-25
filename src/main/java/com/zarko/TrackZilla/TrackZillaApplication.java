package com.zarko.TrackZilla;

import com.zarko.TrackZilla.entity.Application;
import com.zarko.TrackZilla.repository.ApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrackZillaApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrackZillaApplication.class, args);
		System.out.println("Hello from JAVA SPRING FRAMEWORK");
	}

    @Bean
	public CommandLineRunner demo(ApplicationRepository repository){
		return (args) -> {
		//repository.save(new Application("TrackZilla", "Oleg", "Demo application from console"));
		};
	}

}
