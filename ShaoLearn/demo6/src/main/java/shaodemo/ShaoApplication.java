package shaodemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import shaodemo.service.LiService;
import shaodemo.service.ShaoService;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-25 12:43
 */
public class ShaoApplication {

    public static void main(String args[]) {
        //
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/applicationContext.xml");
        //c# is关键字的替代方式
        System.out.println(applicationContext instanceof FileSystemXmlApplicationContext);
        ShaoService shaoService=(ShaoService) applicationContext.getBean("shaoservice1");
       if(applicationContext.getBean("shaoservice1").getClass()==LiService.class)
       {
           System.out.println("ddd");
       }
       shaoService.addData("test");

        //shaoService.addData("test");
    }
}
