package com.dongnao.language;

/**
 * @author Five��ʦ
 * @createTime 2018��1��17�� ����10:44:04
 * @readme �Զ�װ�������
 */
public class AutoPackingDemo1 {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        //Integer.valueOf(127);// װ�� -128 �� 127 ����������ȡ�����е�ֵ������ new Integer
        System.out.println("a == b : " + (a == b));
        Integer c = 130;
        Integer d = 130;
        System.out.println("c == d : " + (c == d));
    }
}
