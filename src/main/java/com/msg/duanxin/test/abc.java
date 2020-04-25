package com.msg.duanxin.test;

/**
 * @author quanmin
 * @create 2019-12-20 0:15
 */
public class abc {
    public static void main(String args[]){
        AB s = new AB("hello!","I love JAVA.");
        System.out.println(s.toString());
    }

}

class AB{
    String s1;
    String s2;
    public AB(String str1,String str2){
        s1 = str1;
        s2 = str2;
    }
    public String toString(){
        return s1+s2;
    }
}
