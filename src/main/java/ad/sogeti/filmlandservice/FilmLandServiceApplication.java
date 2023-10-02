package ad.sogeti.filmlandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FilmLandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmLandServiceApplication.class, args);
	}

}
