package tmoonlight.srvfour;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableEurekaClient
@MapperScan("tmoonlight.srvfour.dao")
public class SrvFourApplication {
    public static void main(String args[]) {
        SpringApplication.run(SrvFourApplication.class);
    }
}
