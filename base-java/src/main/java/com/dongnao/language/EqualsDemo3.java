package com.dongnao.language;
/**
 * 
 * @author Five老师
 * @createTime 2018年1月17日 上午10:36:34
 * @readme hashcode()与euals
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
		//JDK根据对象的地址计算int型哈希码值
		EqualsDemo3 obj = new EqualsDemo3();
		obj.setAge(12);
		System.out.println("对象第一次调用hashcode:"+obj.hashCode());
		System.out.println("对象第二次调用hashcode:"+obj.hashCode());
		obj.setAge(20);
		obj.setName("Five");
		System.out.println("对象第三次调用hashcode:"+obj.hashCode());
		
		//JDK根据字符串值计算int型哈希码值
		String str1 = "abc";
		System.out.println("字符串第一次调用hashcode:"+str1.hashCode());
		System.out.println("字符串第二次调用hashcode:"+str1.hashCode());
		str1 = "xyz";
		System.out.println("字符串第三次调用hashcode:"+str1.hashCode());
		
		String str2 = "xyz";
		System.out.println("str2.equals(str1):"+str2.equals(str1));
		System.out.println("str2 hashcode:"+str2.hashCode());
	}
}
