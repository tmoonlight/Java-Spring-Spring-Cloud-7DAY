package shaodemo;

import com.cyyz.spt.platform.common.util.Base64Util;
import jdk.net.Sockets;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.security.crypto.codec.Utf8;
import shaodemo.service.LiService;
import shaodemo.service.ShaoService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-25 12:43
 */
public class ShaoApplication {

    //@Value("socketPort")
    public static int socketPort = 8222;
    public static void main(String args[]) throws Exception {
        //
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/applicationContext.xml");
        //c# is关键字的替代方式
        System.out.println(applicationContext instanceof FileSystemXmlApplicationContext);
        ShaoService shaoService = (ShaoService) applicationContext.getBean("shaoservice1");
        if (applicationContext.getBean("shaoservice1").getClass() == LiService.class) {
            System.out.println("ddd");
        }
        String TestString = "Select * from wf_test2.test_table1";
        //编码转换为啥不行呢
        //System.out.println(new String(TestString.getBytes("UTF-8"),"UTF-8").toString());
//        System.out.println(Base64Util.encode(TestString.getBytes()));
//       shaoService.addData("test");
//       Thread.sleep(3000);
//        System.out.println(Base64Util.encode(TestString.getBytes()));
//        Thread.sleep(3000);
//        System.out.println(Base64Util.encode(TestString.getBytes()));
//        Thread.sleep(3000);
//        System.out.println(Base64Util.encode(TestString.getBytes()));
//        Thread.sleep(3000);


        File f = new File("c:/1.txt");
        if (!f.exists())
            f.createNewFile();

        FileInputStream fiStream = new FileInputStream(f);
        FileOutputStream foutStream = new FileOutputStream(f);

        //fiStream.read()

        foutStream.write(TestString.getBytes());
        foutStream.close();

        ServerSocket ss = new ServerSocket(socketPort);
        while (1==1) {
            Socket socket = ss.accept();
            //以下过程需要全异步
            socket.getInputStream();

            InputStream inputStream = socket.getInputStream();
            //OutputStream outputStream = socket.getOutputStream();
            //outputStream.write("测试".getBytes());

            //一次性全部读出
            byte[] bytes= new byte[1024];
            inputStream.read(bytes);
            //socket.close();
            System.out.println(new String(bytes,"UTF-8"));
            inputStream.close();
            //(new Socket()).connect();

        }
//
//        while ()
//        {
//
//        }


        //Sockets skt = Sockets.

//       try
//
//       {
//           throw new Exception("teet");
//       }
//       catch (Exception ex)
//       {
//           //
//       }

        //shaoService.addData("test");
    }
}
