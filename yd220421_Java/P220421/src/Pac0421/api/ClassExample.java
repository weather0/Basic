package Pac0421.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassExample {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("java.lang.String");
			Method[] methods = cls.getDeclaredMethods();
			for(Method method : methods) {
				System.out.println(method.getName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------");
		Class obj = ObjectExample.class;
		Constructor[] cons = obj.getDeclaredConstructors();
		for(Constructor construct : cons) {
			System.out.println(construct.getName());
		}
		
		
		
	}
}
