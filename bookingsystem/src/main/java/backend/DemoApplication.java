package backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

//mvn spring-boot:run -Dspring-boot.run.profiles=dev
//mvn spring-boot:run -Dspring-boot.run.profiles=prod