package com.msg.duanxin.test;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author quanmin
 * @create 2019-12-22 16:31
 */
public class SortA {
    public static void main(String[] args) {
        String str="123a5Ahasbgs";
        char[] chars = str.toCharArray();
        ArrayList<Character> arrayList=new ArrayList<>();
        for (char aChar : chars) {
            arrayList.add(aChar);
        }
        Collections.sort(arrayList); //集合排序
//        for (Character character : arrayList) {
//            System.out.print(character+"\t");
//        }
        char a='a';
        for(int i=0;i<arrayList.size()-1;i++){
            if(arrayList.get(i+1)-arrayList.get(i)==32){
                a=arrayList.get(i+1);
                arrayList.set(i+1,arrayList.get(i));
                arrayList.set(i,a);
            }
        }
        System.out.println(arrayList);
    }
}
