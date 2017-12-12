package com.jack.test.lang.lambda;
@FunctionalInterface
public interface MyFunction<T> {
	void action(T t);
	default void defaultMethod() { 
		System.out.println("sfsf");
    } 
	static void sfsf(){
		System.out.println("sfsf");
	}
}
