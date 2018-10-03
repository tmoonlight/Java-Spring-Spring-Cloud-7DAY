package tmoonlight.rchat.service;

import org.springframework.stereotype.Service;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-27 12:56
 */
@Service
public  class ShaoServiceImpl implements ShaoService {

    @Override
    public String DoLambda(LabMethod labMethod) {
        labMethod.Run();
        return null;
    }
}
