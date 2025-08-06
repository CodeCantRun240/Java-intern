package backend;

import backend.model.CreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        log.debug("Running");


    }
}

//mvn spring-boot:run -Dspring-boot.run.profiles=dev
//mvn spring-boot:run -Dspring-boot.run.profiles=prod