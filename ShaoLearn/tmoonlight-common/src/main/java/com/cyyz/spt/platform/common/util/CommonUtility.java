package com.cyyz.spt.platform.common.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cyjxc1 on 2017/6/13.
 */
public class CommonUtility {
    public static Date getInspectDate(Date date, int startInspectDayNumber, int endInspectDayNumber,List<Date> holidayList,List<Date> offdayList)
    {
        int addDayNumber=1;
        date=DateUtil.dateAddByDay(date,addDayNumber);

        if (DateUtil.isOffDay(date,offdayList))
        {
            startInspectDayNumber++;
        }
        else
        {
            if (!DateUtil.isWeekends(date))
            {
                if (!DateUtil.isHoliday(date,holidayList)){
                    startInspectDayNumber++;
                }
            }
        }
        if (startInspectDayNumber < endInspectDayNumber)
        {
            return getInspectDate(date, startInspectDayNumber, endInspectDayNumber,holidayList,offdayList);
        }
        return date;
    }

    public static Date getDateTime(String str){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(str);
        }
        catch(Exception e)
        {}
        return null;
    }
    public static Date getDate(String str){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.parse(str);
        }
        catch(Exception e)
        {}
        return null;
    }
    public static int getInt(String str){
        try {
            return Integer.parseInt(str);
        }
        catch(Exception e)
        {}
        return 0;
    }
    public static float getFloat(String str){
        try {
            return Float.parseFloat(str);
        }
        catch(Exception e)
        {}
        return 0f;
    }
    public static byte[] getByte(String str){
        try {
            return str.getBytes();
        }
        catch(Exception e)
        {}
        return null;
    }
    public static boolean getBoolean(String str){
       if(str.equals("1")) {
           return true;
       }
       return false;
    }

    public static boolean isIdCard(String str) {
        if (str.length() == 18) {
            String lastChar = str.substring(str.length() - 1);
            if (lastChar.equals("0")
                    || lastChar.equals("1")
                    || lastChar.equals("2")
                    || lastChar.equals("3")
                    || lastChar.equals("4")
                    || lastChar.equals("5")
                    || lastChar.equals("6")
                    || lastChar.equals("7")
                    || lastChar.equals("8")
                    || lastChar.equals("9")
                    || lastChar.equals("x")
                    || lastChar.equals("X")) {
                return true;
            }
        }
        return false;
    }
}
