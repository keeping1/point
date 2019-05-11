package com.example.point.cmcc.util;

import java.util.UUID;

/**
 * @auther wangkaiguang
 * @date 2019/5/5
 */
public class StringUtil1 {

    public static String getMoblieUrl(String str,String str1) {
       String [] array = str.split("&");
        String newstr = "";
        for (String s : array){
            if (s.startsWith(str1)){
                newstr=s.substring(s.indexOf("=")+1,s.length());
            }
        }
        return newstr;
    }
}
