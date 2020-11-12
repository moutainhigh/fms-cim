package org.fms.cim.server.webapp.uas.helper;

import org.fms.cim.common.vo.uas.PCalcTaskDataTypeVO;

import java.util.ArrayList;
import java.util.List;

public class UtilityHelper {

    public static final String caclTaskDataType="000000000000000" +
            "000000000000000" +
            "000000000000000" +
            "000000000000000" +
            "000000000000000" +
            "000000000000000" ;

    /**
     * 用正则表达式进行判断ip地址
     */
    public static boolean isIPAddressByRegex(String str) {
        String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        // 判断ip地址是否与正则表达式匹配
        if (str.matches(regex)) {
            String[] arr = str.split("\\.");
            for (int i = 0; i < 4; i++) {
                int temp = Integer.parseInt(arr[i]);
                //如果某个数字不是0到255之间的数 就返回false
                if (temp < 0 || temp > 255) return false;
            }
            return true;
        } else return false;
    }

    /**
     * 正则表达式验证邮箱
     */
    public static boolean isEmail(String email) {
        if (email == null || "".equals(email)) return false;
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }

    /**
     * 正则表达式验证手机
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || "".equals(phoneNumber))
            return false;
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";
        return phoneNumber.matches(regex);
    }

    public static List<PCalcTaskDataTypeVO> getDataType() {
        List<PCalcTaskDataTypeVO> dataTypeList=new ArrayList<>();
        for (int i = 1; i < 65; i++) {
            switch (i) {
                case 1:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向有功（总）"));
                    break;
                case 2:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向有功（尖）"));
                    break;
                case 3:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向有功（峰）"));
                    break;
                case 4:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向有功（平）"));
                    break;
                case 5:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向有功（谷）"));
                    break;
                case 9:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向有功（总）"));
                    break;
                case 10:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向有功（尖）"));
                    break;
                case 11:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向有功（峰）"));
                    break;
                case 12:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向有功（平）"));
                    break;
                case 13:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向有功（谷）"));
                    break;
                case 17:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向无功（总）"));
                    break;
                case 18:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向无功（尖）"));
                    break;
                case 19:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向无功（峰）"));
                    break;
                case 20:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向无功（平）"));
                    break;
                case 21:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"正向无功（谷）"));
                    break;
                case 25:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向无功（总）"));
                    break;
                case 26:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向无功（尖）"));
                    break;
                case 27:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向无功（峰）"));
                    break;
                case 28:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向无功（平）"));
                    break;
                case 29:
                    dataTypeList.add(new PCalcTaskDataTypeVO(i,"反向无功（谷）"));
                    break;
                default:
                    //dataTypeList.add(new CalcTaskDataType(i,""));
                    break;
            }
        }
        return dataTypeList;
    }
}
