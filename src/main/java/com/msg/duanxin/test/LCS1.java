package com.msg.duanxin.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quanmin
 * @create 2019-12-14 20:13
 */
public class LCS1 {

    public static List pre(String astr, String bstr){
        char[] ach = astr.toCharArray();
        char[] bch = astr.toCharArray();
        int alen = ach.length;
        int blen = bch.length;
        List zc = new ArrayList();
        for(int i = 0;i<alen;i++){

        }
        return null;
    }

    public static char[] strHelp(int i,int j,char[] chars){
        int len = j-i;
        char[] c = new char[j-i];
        for(int z = 0;z<len;z++){
            c[z] = chars[i];
            i++;
        }
        return c;
    }


    public static void main(String[] args) {

        System.out.println(strHelp(3,5,"abcde".toCharArray()));
    }
}
