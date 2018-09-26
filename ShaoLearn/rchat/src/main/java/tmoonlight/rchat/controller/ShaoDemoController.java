package tmoonlight.rchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tmoonlight.rchat.vo.UserVO;

import java.util.Map;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-26 18:18
 */
@Controller
public class ShaoDemoController {

    //<editor-fold desc="一坨接口">
    @RequestMapping("/temp")
    public String index(Map<String, String> map) {
        map.put("info", "测试thymlaf！");
        return "testshao";
    }

    @RequestMapping("/success")
    public String success(UserVO userVO,Map<String, String> map) {
        map.put("info", "提交成功！用户名为" + userVO.getUserName());
        return "success";
    }
    //</editor-fold>


}
