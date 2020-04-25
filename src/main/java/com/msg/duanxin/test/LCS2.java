package com.msg.duanxin.test;

import java.util.List;

/**
 * @author quanmin
 * @create 2019-12-14 20:35
 */
public class LCS2 {

    public static List any(String str){
        char[] chars = str.toCharArray();
        int len = chars.length;
        for(int i=0;i<len;i++){
            for (int j = 0; j < charNumHelp(i,len); j++) {

            }
        }
        return null;
    }
    public static int charNumHelp(int i,int num){
        int fz = 1;
        int fm = 1;
        for (int j = 0;j<i;j++){
            fz = num*fz;
            num--;
        }
        for (int j = 0;j<i;j++){
            fm = i*fm;
            i--;
        }
        return fz/fm;
    }
}
