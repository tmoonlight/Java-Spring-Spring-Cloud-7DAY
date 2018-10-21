package tmoonlight.srvapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tmoonlight.srvapi.service.DemoService;

import javax.annotation.Resource;

@RequestMapping("/api")
@RestController
public class RootController {

    @Resource
    DemoService demoService;

    @RequestMapping("cast")
    public String DemoDo(){


        return demoService.TeShao();
    }
}
