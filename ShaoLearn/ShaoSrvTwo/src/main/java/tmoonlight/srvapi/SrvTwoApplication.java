package tmoonlight.srvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SrvTwoApplication {
    public static void main(String args[]) {
        SpringApplication.run(SrvTwoApplication.class);
    }
}
