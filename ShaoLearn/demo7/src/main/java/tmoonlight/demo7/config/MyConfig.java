package tmoonlight.demo7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-25 20:07
 */
@Configuration
public class MyConfig {
    @Bean
    public String testHaha(){
        Logger.getLogger("test").info("测试");
        System.out.println("haha1");
        return  "haha";
    }
}
