package com.musala.fpextended;

public class TypeOfLambda {

	static void doSomething() {
		System.out.println("run");
	}
	
	public static void main(String[] args) {
		
		ParamRunnable r = (x) -> x + 1;
		r.run(15);
		
//		ParamRunnable r = (x) -> System.out.println(x);
//		
//		r.run(5);
		
		//return a lambda
	}
}

@FunctionalInterface
interface ParamRunnable {
	int run(int x);
}
