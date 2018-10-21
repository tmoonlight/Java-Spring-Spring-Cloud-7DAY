package tmoonlight.srvone.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import tmoonlight.srvone.dao.CustomerMapper;
import tmoonlight.srvone.model.Customer;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    CustomerMapper customerMapper;
    @Override
    public String TestMySql()
    {
        Customer customer = customerMapper.selectByPrimaryKey(11);
        String s = "";
        return JSONObject.toJSONString(customer);
    }
}
