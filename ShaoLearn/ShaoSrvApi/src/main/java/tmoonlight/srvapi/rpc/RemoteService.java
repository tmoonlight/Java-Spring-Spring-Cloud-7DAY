package tmoonlight.srvapi.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="ShaoSrvOne")
public interface RemoteService {
    @RequestMapping("/demo/test1")
    public String DemoDo() ;


}
