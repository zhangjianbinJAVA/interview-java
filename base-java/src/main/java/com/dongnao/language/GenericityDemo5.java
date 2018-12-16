package com.dongnao.language;

import java.util.ArrayList;

/**
 * 
 * @author Five老师
 * @createTime 2018年1月17日 上午10:49:22
 * @readme 泛型
 */
public class GenericityDemo5 {
	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		//当取出list中元素使用时,可能需要强制转换,导致类型转换失败.
		arr.add(1);
		arr.add("a");
		
		//泛型擦除:Java编译期间泛型信息会被擦除,编译后变成原始类型
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<String> arr2 = new ArrayList<String>();
		System.out.println(arr1.getClass()==arr2.getClass());
		
		/**不指定泛型的时候*/
        int i=GenericityDemo5.add(1, 2); //这两个参数都是Integer，所以T替换为Integer类型
        Number f=GenericityDemo5.add(1, 1.2);//这两个参数一个是Integer，另一个是Float，所以取同一父类的最小级，为Number
        Object o=GenericityDemo5.add(1, "asd");//这两个参数一个是Integer，另一个是String，所以取同一父类的最小级，为Object
    
        /**指定泛型的时候*/
        int a1=GenericityDemo5.<Integer>add(1, 2);//指定了Integer，所以只能为Integer类型或者其子类
        //int b1=GenericityDemo5.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float
        Number c1=GenericityDemo5.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
        
	}
	
	//这是一个简单的泛型方法    
    public static <T> T add(T x,T y){    
        return y;    
    }
}
