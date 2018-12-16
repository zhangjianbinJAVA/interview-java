package com.dongnao.language;
/**
 * 
 * @author Five��ʦ
 * @createTime 2018��1��17�� ����10:36:34
 * @readme hashcode()��euals
 */
public class EqualsDemo3 {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public static void main(String[] args) {
		//JDK���ݶ���ĵ�ַ����int�͹�ϣ��ֵ
		EqualsDemo3 obj = new EqualsDemo3();
		obj.setAge(12);
		System.out.println("�����һ�ε���hashcode:"+obj.hashCode());
		System.out.println("����ڶ��ε���hashcode:"+obj.hashCode());
		obj.setAge(20);
		obj.setName("Five");
		System.out.println("��������ε���hashcode:"+obj.hashCode());
		
		//JDK�����ַ���ֵ����int�͹�ϣ��ֵ
		String str1 = "abc";
		System.out.println("�ַ�����һ�ε���hashcode:"+str1.hashCode());
		System.out.println("�ַ����ڶ��ε���hashcode:"+str1.hashCode());
		str1 = "xyz";
		System.out.println("�ַ��������ε���hashcode:"+str1.hashCode());
		
		String str2 = "xyz";
		System.out.println("str2.equals(str1):"+str2.equals(str1));
		System.out.println("str2 hashcode:"+str2.hashCode());
	}
}
