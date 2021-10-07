package vn.techmaster.filmlisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

@SpringBootApplication
public class FilmlistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmlistingApplication.class, args);
	}
}


