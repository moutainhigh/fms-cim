package org.fms.cim.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fms.cim.common.domain.archives.MeterReplaceDomain;
import org.fms.cim.common.domain.archives.WriteFilesDomain;

/**
 * 通用工具类
 */
public class CommonUtil {

    /**
     *
     * @param number 需要格式化的字符
     * @param digit  格式化多少位
     * @param character 替代符
     * @param direction true前面填充替代符 false右面填充替代符
     * @return
     */
    public static String generateFormatNo(String number,int digit,
                                        String character,
                                   boolean direction){
        int strLen = number.length();
        if(strLen>=digit){
            return number;
        }
        StringBuffer sb = null;
        while (strLen < digit) {
            sb = new StringBuffer();
            if(direction){
                sb.append(character).append(number);// 左补0
            }else{
                sb.append(number).append(character);//右补0

            }
            number = sb.toString();
            strLen = number.length();
        }
        return number;
    }

    /**
     * 获得年月日 如20190919
     * @return
     */
    public static List<String> getYMD() {
        String[] strNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
        String year = strNow[0];
        String month = strNow[1];
        String day = strNow[2];
        List<String> returnList = new ArrayList<>();
        returnList.add(year);
        returnList.add(month);
        returnList.add(day);
        return returnList;
    }

    public static List<WriteFilesDomain> transCjToMis(MeterReplaceDomain meterReplaceLastCode){
        List<WriteFilesDomain> writeFilesDomains=new ArrayList<>();
        //总正有
        WriteFilesDomain zzy=new WriteFilesDomain();
        zzy.setTimeSeg((byte)0);
        zzy.setPowerDirection("1");
        zzy.setFunctionCode("1");
        zzy.setEndNum(meterReplaceLastCode.getP1r0());
        //总段反有
        WriteFilesDomain zfy=new WriteFilesDomain();
        zfy.setTimeSeg((byte)0);
        zfy.setPowerDirection("2");
        zfy.setFunctionCode("1");
        zfy.setEndNum(meterReplaceLastCode.getP2r0());

        //总正无
        WriteFilesDomain zzw=new WriteFilesDomain();
        zzw.setTimeSeg((byte)0);
        zzw.setPowerDirection("1");
        zzw.setFunctionCode("2");
        zzw.setEndNum(meterReplaceLastCode.getP3r0());
        //总反无
        WriteFilesDomain zfw=new WriteFilesDomain();
        zfw.setTimeSeg((byte)0);
        zfw.setPowerDirection("2");
        zfw.setFunctionCode("2");
        zfw.setEndNum(meterReplaceLastCode.getP4r0());


        //尖正有
        WriteFilesDomain jzy=new WriteFilesDomain();
        jzy.setTimeSeg((byte)4);
        jzy.setPowerDirection("1");
        jzy.setFunctionCode("1");
        jzy.setEndNum(meterReplaceLastCode.getP1r1());
        //尖反有
        WriteFilesDomain jfy=new WriteFilesDomain();
        jfy.setTimeSeg((byte)4);
        jfy.setPowerDirection("2");
        jfy.setFunctionCode("1");
        jfy.setEndNum(meterReplaceLastCode.getP2r1());

        //尖正无
        WriteFilesDomain jzw=new WriteFilesDomain();
        jzw.setTimeSeg((byte)4);
        jzw.setPowerDirection("1");
        jzw.setFunctionCode("2");
        jzw.setEndNum(meterReplaceLastCode.getP3r1());
        //尖反无
        WriteFilesDomain jfw=new WriteFilesDomain();
        jfw.setTimeSeg((byte)4);
        jfw.setPowerDirection("2");
        jfw.setFunctionCode("2");
        jfw.setEndNum(meterReplaceLastCode.getP4r1());

        //峰正有
        WriteFilesDomain fzy=new WriteFilesDomain();
        fzy.setTimeSeg((byte)1);
        fzy.setPowerDirection("1");
        fzy.setFunctionCode("1");
        fzy.setEndNum(meterReplaceLastCode.getP1r2());
        //峰反有
        WriteFilesDomain ffy=new WriteFilesDomain();
        ffy.setTimeSeg((byte)1);
        ffy.setPowerDirection("2");
        ffy.setFunctionCode("1");
        ffy.setEndNum(meterReplaceLastCode.getP2r2());

        //峰正无
        WriteFilesDomain fzw=new WriteFilesDomain();
        fzw.setTimeSeg((byte)1);
        fzw.setPowerDirection("1");
        fzw.setFunctionCode("2");
        fzw.setEndNum(meterReplaceLastCode.getP3r2());
        //峰反无
        WriteFilesDomain ffw=new WriteFilesDomain();
        ffw.setTimeSeg((byte)1);
        ffw.setPowerDirection("2");
        ffw.setFunctionCode("2");
        ffw.setEndNum(meterReplaceLastCode.getP4r2());

        //平正有
        WriteFilesDomain pzy=new WriteFilesDomain();
        pzy.setTimeSeg((byte)2);
        pzy.setPowerDirection("1");
        pzy.setFunctionCode("1");
        pzy.setEndNum(meterReplaceLastCode.getP1r3());
        //平反有
        WriteFilesDomain pfy=new WriteFilesDomain();
        pfy.setTimeSeg((byte)2);
        pfy.setPowerDirection("2");
        pfy.setFunctionCode("1");
        pfy.setEndNum(meterReplaceLastCode.getP2r3());

        //平正无
        WriteFilesDomain pzw=new WriteFilesDomain();
        pzw.setTimeSeg((byte)2);
        pzw.setPowerDirection("1");
        pzw.setFunctionCode("2");
        pzw.setEndNum(meterReplaceLastCode.getP3r3());
        //平反无
        WriteFilesDomain pfw=new WriteFilesDomain();
        pfw.setTimeSeg((byte)2);
        pfw.setPowerDirection("2");
        pfw.setFunctionCode("2");
        pfw.setEndNum(meterReplaceLastCode.getP4r3());


        //谷正有
        WriteFilesDomain gzy=new WriteFilesDomain();
        gzy.setTimeSeg((byte)3);
        gzy.setPowerDirection("1");
        gzy.setFunctionCode("1");
        gzy.setEndNum(meterReplaceLastCode.getP5r3());
        //谷反有
        WriteFilesDomain gfy=new WriteFilesDomain();
        gfy.setTimeSeg((byte)3);
        gfy.setPowerDirection("2");
        gfy.setFunctionCode("1");
        gfy.setEndNum(meterReplaceLastCode.getP5r3());

        //谷正无
        WriteFilesDomain gzw=new WriteFilesDomain();
        gzw.setTimeSeg((byte)3);
        gzw.setPowerDirection("1");
        gzw.setFunctionCode("2");
        gzw.setEndNum(meterReplaceLastCode.getP5r3());
        //谷反无
        WriteFilesDomain gfw=new WriteFilesDomain();
        gfw.setTimeSeg((byte)3);
        gfw.setPowerDirection("2");
        gfw.setFunctionCode("2");
        gfw.setEndNum(meterReplaceLastCode.getP5r3());

        writeFilesDomains.add(zfw);
        writeFilesDomains.add(zfy);
        writeFilesDomains.add(zzw);
        writeFilesDomains.add(zzy);

        writeFilesDomains.add(jfw);
        writeFilesDomains.add(jfy);
        writeFilesDomains.add(jzw);
        writeFilesDomains.add(jzy);

        writeFilesDomains.add(ffw);
        writeFilesDomains.add(ffy);
        writeFilesDomains.add(fzw);
        writeFilesDomains.add(fzy);

        writeFilesDomains.add(pfw);
        writeFilesDomains.add(pfy);
        writeFilesDomains.add(pzw);
        writeFilesDomains.add(pzy);

        writeFilesDomains.add(gfw);
        writeFilesDomains.add(gfy);
        writeFilesDomains.add(gzw);
        writeFilesDomains.add(gzy);
        return  writeFilesDomains;
    }
}
