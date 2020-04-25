package com.msg.duanxin.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Handler;

/**
 * @author quanmin
 * @create 2019-12-20 0:25
 */
public class Sort {

    public static void main(String[] args) {
        String str = "3Ba1cA";
        char[] chars = str.toCharArray();
        int len = chars.length;
        List<Character> list = new LinkedList<>();
        for(int i =0;i<len-2;i++){
            list.add(chars[i]);
            if(chars[i]<=chars[i+1]){
                list.set(i+1,chars[i+1]);
            }else{
                ((LinkedList<Character>) list).addFirst(chars[i+1]);
            }
        }
        for (Character character : list) {
            System.out.println(character);
        }
    }

    public static char[] handleFirst(String str){
        char[] chars = str.toCharArray();
        List list = Collections.singletonList(chars);
        for(int i =0;i<chars.length-1;i++){
            for(int j = 0;j<chars.length-i-1;j++)
            if(chars[j]>chars[j+1]){
                char temp = chars[j+1];
                chars[j+1] = chars[j];
                chars[j] = temp;
            }
        }
        return chars;
    }

    public static List handleUp(String str){
        char[] chars = str.toCharArray();
        List list = new ArrayList();
        for(int i =0;i<chars.length-1;i++){
            if(chars[i]>=97&&chars[i]<=122){
                list.add(chars[i]);
            }
        }
        return list;
    }

    public static String HandlerSecond(char[] chars){

        int len = chars.length;
        char[] chars1 = new char[len];
        for(int i = 0;i<len;i++){
            int j = i+1;
            for (; j < len; j++) {
                if(chars[i]+32==chars[j]){

                }else{

                }
            }
            chars1[i] = chars[i];
        }
        return null;
    }
}
