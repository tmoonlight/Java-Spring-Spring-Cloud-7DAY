package shaodemo.instruction;

import org.apache.log4j.Logger;

/**
 * @Author: SHZ
 * @Description:
 * @Date: Created in 2018-09-25 16:16
 */
public class TimeHandler {
    static Logger logger = Logger.getLogger(TimeHandler.class.getName());
    public void printTime()
    {
        System.out.println("打印时间"+System.currentTimeMillis());
        logger.info("这是一个信息");
    }
}
