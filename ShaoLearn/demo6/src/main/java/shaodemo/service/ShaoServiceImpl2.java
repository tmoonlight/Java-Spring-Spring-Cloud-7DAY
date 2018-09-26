package shaodemo.service;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-25 12:46
 */
public class ShaoServiceImpl2 implements ShaoService {

    /**
     * override接口继承不需要
     * @param strData 参数
     */
    public void addData(String strData) {
        System.out.println("addData第二版执行成功！");
    }

    public void removeData(String strData) {
        System.out.println("删除ShaoService第二版！！！");
    }
}
