package com.dongnao.language;

import java.util.ArrayList;

/**
 * 
 * @author Five��ʦ
 * @createTime 2018��1��17�� ����10:49:22
 * @readme ����
 */
public class GenericityDemo5 {
	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		//��ȡ��list��Ԫ��ʹ��ʱ,������Ҫǿ��ת��,��������ת��ʧ��.
		arr.add(1);
		arr.add("a");
		
		//���Ͳ���:Java�����ڼ䷺����Ϣ�ᱻ����,�������ԭʼ����
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<String> arr2 = new ArrayList<String>();
		System.out.println(arr1.getClass()==arr2.getClass());
		
		/**��ָ�����͵�ʱ��*/
        int i=GenericityDemo5.add(1, 2); //��������������Integer������T�滻ΪInteger����
        Number f=GenericityDemo5.add(1, 1.2);//����������һ����Integer����һ����Float������ȡͬһ�������С����ΪNumber
        Object o=GenericityDemo5.add(1, "asd");//����������һ����Integer����һ����String������ȡͬһ�������С����ΪObject
    
        /**ָ�����͵�ʱ��*/
        int a1=GenericityDemo5.<Integer>add(1, 2);//ָ����Integer������ֻ��ΪInteger���ͻ���������
        //int b1=GenericityDemo5.<Integer>add(1, 2.2);//�������ָ����Integer������ΪFloat
        Number c1=GenericityDemo5.<Number>add(1, 2.2); //ָ��ΪNumber�����Կ���ΪInteger��Float
        
	}
	
	//����һ���򵥵ķ��ͷ���    
    public static <T> T add(T x,T y){    
        return y;    
    }
}
