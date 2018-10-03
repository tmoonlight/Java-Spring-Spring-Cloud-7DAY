package tmoonlight.rchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tmoonlight.rchat.service.ShaoService;
import tmoonlight.rchat.vo.EnvironmentBO;
import tmoonlight.rchat.vo.MyBO;
import tmoonlight.rchat.vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-26 18:18
 */
@Controller
public class ShaoDemoController {

    @Autowired
    EnvironmentBO environmentBO;

    @Autowired
    ShaoService shaoService;

    //<editor-fold desc="一坨接口">
    @RequestMapping("/temp")
    public String index(Map<String, String> map) {
        map.put("info", "测试thymlaf！");

        MyBO bo = new MyBO();
        bo.setField1("test1");
        bo.setField2("testtest");
        bo.setField3("tesdsa 第三方啊t1");
        bo.setField4("test反倒是 第三方");

        System.out.println("======================(*(&*(^&(");
        System.out.println( bo.toString());
        return "testshao";
    }

    @RequestMapping("/success")
    public String success(UserVO userVO, Map<String, String> map) {

        String resultStr = "";
        //map.put("info", "提交成功！用户名为" + userVO.getUserName());

        new Thread(() -> System.out.println("test"));


        //List<String> list = new List<String>();//{"test","test2"};
        //String[] strArray = new String[]{"test","test2","test3"};
        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        String testStr = list.get(0);
        //list.forEach();
        //public void forEach(Consumer<? super E> action) {
        //
       // list.forEach(str->{str});
        //java.util.function.
        HashMap<String,String> hmap = new HashMap<String,String>();
        map.put("info", resultStr);

        shaoService.DoLambda(()->{
            System.out.println("labda表达式运行！");
        });


        return "success";
    }

    @RequestMapping("/nullpage")
    public String nullpage(UserVO userVO, Map<String, String> map) {
        // map.put("info", "提交成功！用户名为" + userVO.getUserName());
        return "nullpage";
    }
    //</editor-fold>


}
