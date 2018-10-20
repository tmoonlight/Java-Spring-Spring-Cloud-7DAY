package tmoonlight.rchat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("tmoonlight.rchat.dao")
public class RchatApplication {

    public static void main(String[] args) {

        SpringApplication.run(RchatApplication.class, args);
    }

//    @Bean
//    //等同于返回一个方法委托 好比给注入加入了一个事件钩子
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        System.out.println("*****************");
//        return args -> {
//            System.out.println("===================");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//            System.out.println("===================");
//            System.out.println(String.format("测试%s,%s,%s","123","432432",null));
//
//        };
//    }
}
