package com.cyyz.spt.platform.common.util;

/**
 * Created by Administrator on 2018/3/6 0006.
 */
public class SZApproveCodeUtil {

    public static String getPCDepartmentNameByApproveCode(String approveCode){

        String departmentName = null;
        switch (approveCode){
            case "sznsfj":
                departmentName = "南山分局";
                break;
            case "szftfj":
                departmentName = "福田分局";
                break;
            case "szjcfj":

            case "sdywfj":

            case "szsgaj":
                departmentName = "市公安局";
                break;
            case "szsmzx":
                departmentName = "市明中心分局";
                break;
            case "szlhfj":
                departmentName = "罗湖分局";
                break;
            case "szbafj":
                departmentName = "宝安分局";
                break;
            case "szlgfj":
                departmentName = "龙岗分局";
                break;
             case "szytfj":
                 departmentName = "盐田分局";
                 break;
            case "szgmfj":
                departmentName = "光明分局";
                break;
            case "szpsfj":
                departmentName = "坪山分局";
                break;
            case "szbalh":
                departmentName = "龙华分局";
                break;
            case "szdpfj":
                departmentName = "大鹏分局";
                break;

        }
        return departmentName;


    }
}
