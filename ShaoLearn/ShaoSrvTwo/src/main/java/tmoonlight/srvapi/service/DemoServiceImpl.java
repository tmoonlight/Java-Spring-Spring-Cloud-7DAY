package tmoonlight.srvapi.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import tmoonlight.srvapi.dao.CustomerMapper;
import tmoonlight.srvapi.model.Customer;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    CustomerMapper customerMapper;

    @Override
    public String TeShao() {
        Customer customer = customerMapper.selectByPrimaryKey(10);
        String s = "++++++++teShao++++";
        return s + JSONObject.toJSONString(customer);
    }

}
