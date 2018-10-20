package tmoonlight.rchat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tmoonlight.rchat.dao.CustomerMapper;
import tmoonlight.rchat.model.Customer;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-27 12:56
 */
@Service

public class ShaoServiceImpl implements ShaoService {


    @Autowired
    CustomerMapper customerMapper;
    @Override
    public String DoLambda(LabMethod labMethod) {
        labMethod.Run();
        return null;
    }


    @Override
    public void doManyProc() {
        //执行事务1
        Customer customer = customerMapper.selectByPrimaryKey(11);

        //执行事务2
    }
}
