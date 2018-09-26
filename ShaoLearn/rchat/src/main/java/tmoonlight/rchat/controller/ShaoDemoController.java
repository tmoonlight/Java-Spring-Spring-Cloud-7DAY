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

    @RequestMapping("/temp")
    public String index(Map<String, String> map) {
        map.put("info", "测试thymleaf！");
        return "testshao";
    }

    @RequestMapping("/success")
    public String success(Map<String, String> map, UserVO userVO) {
        map.put("info", "提交成功！用户名为" + userVO.getUserName());
        return "success";
    }


}
