package com.example.point.cmcc.util;

/**
 * @auther wangkaiguang
 * @date 2019/5/5
 */
public class StringUtil {

    public static String getMoblieUrl(String str) {
       String [] array = str.split("&");
        String newstr = "";
        for (String s : array){
            if (s.startsWith("mobileUrl")){
                newstr=s.substring(s.indexOf("=")+1,s.length());
            }
        }
        return newstr;
    }
}
