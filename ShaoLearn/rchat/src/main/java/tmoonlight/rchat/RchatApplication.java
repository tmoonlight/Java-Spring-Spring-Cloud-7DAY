package tmoonlight.rchat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RchatApplication {

    public static void main(String[] args) {

        SpringApplication.run(RchatApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        System.out.println("*****************");
        return args -> {
            System.out.println("===================");
            String[] beanNames = ctx.getBeanDefinitionNames();

            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            System.out.println("===================");
            System.out.println(String.format("测试%s,%s,%s","123","432432",null));

        };
    }
}
