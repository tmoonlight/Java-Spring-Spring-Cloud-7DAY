package tmoonlight.srvapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmoonlight.srvapi.dao.CustomerMapper;
import tmoonlight.srvapi.rpc.RemoteService;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    CustomerMapper customerMapper;

    @Autowired
    RemoteService remoteService;
    @Override
    public String TeShao() {
//        Customer customer = customerMapper.selectByPrimaryKey(10);
//        String s = "++++++++teShao++++";

        return  remoteService.DemoDo();
    }

}
