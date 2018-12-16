package com.dongnao.language;

/**
 * @author Five老师
 * @createTime 2018年1月17日 上午10:44:04
 * @readme 自动装箱与拆箱
 */
public class AutoPackingDemo1 {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        //Integer.valueOf(127);// 装箱 -128 到 127 这间的数，则取缓存中的值，否则 new Integer
        System.out.println("a == b : " + (a == b));
        Integer c = 130;
        Integer d = 130;
        System.out.println("c == d : " + (c == d));
    }
}
