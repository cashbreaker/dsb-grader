package one.piotrowski.dsbgrader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DsbGraderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsbGraderApplication.class, args);
    }

}
